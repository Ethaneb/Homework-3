package AI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MinesweeperGUI_AI {
    private static int SIZE = 10; // Size of the board
    private static int MINES = 10; // Number of mines
    private JFrame frame;
    private JButton[][] buttons;
    private char[][] board;
    private int[][] values;
    private boolean[][] revealed;
    private boolean gameOver;
    private boolean[][] flags;


    public MinesweeperGUI_AI(int numMines, int numSize) {
        MINES = numMines;
        SIZE = numSize;
        frame = new JFrame("Minesweeper");
        frame.setLayout(new BorderLayout());


        JLabel heading = new JLabel("Minesweeper", SwingConstants.CENTER);
        heading.setFont(new Font("IMPACT", Font.ITALIC, 5*SIZE));
        heading.setOpaque(true);
        heading.setBackground(Color.decode("#1F618D"));
        heading.setForeground(Color.decode("#EAF2F8"));
        frame.add(heading, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(SIZE, SIZE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttons = new JButton[SIZE][SIZE];
        board = new char[SIZE][SIZE];
        revealed = new boolean[SIZE][SIZE];
        values = new int[SIZE][SIZE];
        flags = new boolean[SIZE][SIZE];
        gameOver = false;

        initializeBoard();
        placeMines();
        calculateValues();
        setupGUI(buttonPanel);
        printBoard();
        printValues();

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Create a panel for the timer and total revealed
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        JLabel timerLabel = new JLabel("Time: 0", SwingConstants.CENTER);
        JLabel revealedLabel = new JLabel("Mines: " + MINES, SwingConstants.CENTER);
        bottomPanel.add(timerLabel);
        bottomPanel.add(revealedLabel);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        timerLabel.setFont(new Font("Impact", Font.PLAIN, 3*SIZE));
        revealedLabel.setFont(new Font("Impact", Font.PLAIN, 3*SIZE));
        timerLabel.setForeground(Color.decode("#EAF2F8"));
        revealedLabel.setForeground(Color.decode("#EAF2F8"));
        bottomPanel.setBackground(Color.decode("#1F618D"));

        // Start a timer
        new Timer(1000, e -> {
            String time = timerLabel.getText();
            int seconds = Integer.parseInt(time.substring(6));
            timerLabel.setText("Time: " + (seconds + 1));
        }).start();

        // Set the size of the frame and make it visible
        frame.pack();
        frame.setVisible(true);

    }

    private void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // If the cell is revealed, print its value
                if (revealed[i][j] == false) {
                    System.out.print(board[i][j] + " ");
                } 
                // If the cell is not revealed, print a dot
                else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private void printValues() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // If the cell is revealed, print its value
                if (revealed[i][j] == false) {
                    System.out.print(values[i][j] + " ");
                } 
                // If the cell is not revealed, print a dot
                else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {    
                board[i][j] = '-';
                revealed[i][j] = false;
                values[i][j] = 0;
                flags[i][j] = false;
            }
        }
    }

    private void revealBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                revealed[i][j] = true;
            }
        }
        updateGUI();
    }

    private void placeMines() {
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < MINES) {
            int x = rand.nextInt(SIZE);
            int y = rand.nextInt(SIZE);
            if (board[x][y] != '*') {
                board[x][y] = '*';
                minesPlaced++;
                System.out.println("Mine placed at (" + x + ", " + y + ")");
            }

        }
    }

    private void calculateValues() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // If the current cell is a mine
                if (board[i][j] == '*') {
                    values[i][j] = -1;
                    // Iterate over the adjacent cells
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            // Calculate the coordinates of the adjacent cell
                            int ni = i + dx;
                            int nj = j + dy;
                            // If the adjacent cell is within the board and is not a mine
                            if (ni >= 0 && ni < SIZE && nj >= 0 && nj < SIZE && board[ni][nj] != '*') {
                                // Increment the value of the adjacent cell
                                values[ni][nj]++;
                            }
                        }
                    }
                }
            }
        }
    }

    private void setupGUI(JPanel buttonPanel) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(50, 50));
                // Button
                int row = i;
                int col = j;
                buttons[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        if (!gameOver) {
                            if (e.getButton() == MouseEvent.BUTTON1) {
                                System.out.println("Left click at (" + row + ", " + col + ")");
                                revealCell(row, col);
                                updateGUI();
                            } else if (e.getButton() == MouseEvent.BUTTON3) {
                                System.out.println("Right click at (" + row + ", " + col + ")");
                                toggleFlag(row, col);
                                updateGUI();
                            }
                        }
                    }
                }
                );
                buttons[i][j].setBackground(Color.decode("#CBDEEA"));
                buttons[i][j].setForeground(Color.BLACK);
                buttonPanel.add(buttons[i][j]);
            }
        }
    }

    private void revealCell(int x, int y) {

        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE || revealed[x][y]) {
            return;
        }

        revealed[x][y] = true;
        if (board[x][y] == '*') {
            gameOver = true;
            revealBoard();
            JOptionPane.showMessageDialog(frame, "Game Over! You hit a mine!");
            frame.dispose();
            System.exit(0);
        } 
        
        
        else if (values[x][y] == 0) {
            // Recursively reveal adjacent cells if they are empty
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {

                    if (i < 0 || i >= SIZE || j < 0 || j >= SIZE || revealed[i][j]) {
                        continue;
                    }
                    else {
                        if(values[i][j] >= 0){
                            revealCell(i, j);
                        }

                    }
                }
            }
        }
    }

    private void updateGUI() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (revealed[i][j]) {
                    if (values[i][j] == -1) {
                        buttons[i][j].setText("*");
                        buttons[i][j].setBackground(Color.RED);
                        buttons[i][j].setForeground(Color.BLACK);
                    }
                    else if (values[i][j] == 0) {
                        buttons[i][j].setText("-");
                        buttons[i][j].setBackground(Color.decode("#7FB3D5"));
                        buttons[i][j].setForeground(Color.BLACK);
                    }
                    else {
                        buttons[i][j].setText(String.valueOf(values[i][j]));
                        buttons[i][j].setBackground(Color.decode("#5499C7"));
                    }
                    buttons[i][j].setEnabled(false);
                }
            }
        }
        checkWin();
    }

    private void checkWin() {
        if(gameOver){
            return;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // If the cell is not a mine and has not been revealed, the game is not won
                if (values[i][j] != -1 && !revealed[i][j]) {
                    return;
                }
            }
        }
    
        // If we reach this point, all non-mine cells have been revealed and the game is won
        JOptionPane.showMessageDialog(frame, "Congratulations! You have won the game!");
        frame.dispose();
        System.exit(0);
    }



    private void toggleFlag(int x, int y) {
        // If the cell has already been revealed, it can't be flagged
        if (revealed[x][y]) {
            return;
        }
        // Toggle the flag status of the cell
        flags[x][y] = !flags[x][y];
        // Update the display to show or hide the flag
        if (flags[x][y]) {
            buttons[x][y].setText("F");
        } else {
            buttons[x][y].setText("");
        }
    }


    public static void main(String[] args) {
        // Display instructions
        JOptionPane.showMessageDialog(null, "Welcome to Minesweeper!\n\n" +
            "Left click on a cell to reveal it.\n" +
            "Right click on a cell to place or remove a flag.\n" +
            "The numbers on the cells indicate the number of mines in the adjacent cells.\n" +
            "The goal is to reveal all cells that do not contain a mine.\n" +
            "Good luck!");
    
        // Ask the user for the number of mines
        String inputMines = JOptionPane.showInputDialog("Enter the number of mines:");
        int numMines = Integer.parseInt(inputMines);
    
        // Ask the user for the size of the board
        String inputSize = JOptionPane.showInputDialog("Enter board length/width:");
        int boardSize = Integer.parseInt(inputSize);
    
        // Initialize and display the game
        SwingUtilities.invokeLater(() -> new MinesweeperGUI_AI(numMines, boardSize));
    }
}

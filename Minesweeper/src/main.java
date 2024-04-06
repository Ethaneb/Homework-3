import javax.swing.JOptionPane;

public class main {
    public static void main(String[] args) {
        Object[] options = {"Run Generated Code", "Run Refactored Code"};
        int option = JOptionPane.showOptionDialog(null,
            "Which version of the code do you want to run?",
            "Choose an option",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]);

        if (option == JOptionPane.YES_OPTION){
            
            JOptionPane.showMessageDialog(null, "Welcome to Minesweeper!\n\n" +
            "Left click on a cell to reveal it.\n" +
            "Right click on a cell to place or remove a flag.\n" +
            "The numbers on the cells indicate the number of mines in the adjacent cells.\n");

            // Ask the user for the number of mines
            String inputMines = JOptionPane.showInputDialog("Enter the number of mines:");
            int numMines = Integer.parseInt(inputMines);
        
            // Ask the user for the size of the board
            String inputSize = JOptionPane.showInputDialog("Enter board length/width:");
            int boardSize = Integer.parseInt(inputSize);
    

            Runnable runnable = () -> new MinesweeperGUI_AI(numMines, boardSize);
            runnable.run();
        }
        
        else if (option == JOptionPane.NO_OPTION){
            Refactored_Minesweeper refactored_minesweeper = new Refactored_Minesweeper();
        }
    
    }
}


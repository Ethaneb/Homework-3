import java.awt.Color;

public class Buttons {
    int board_size;
    Button[][] buttons;
    Board board;

    public Buttons(int board_size, Board board){
        this.board = board;
        this.board_size = board_size;
        this.buttons = new Button[board_size][board_size];
        for(int i = 0; i < board_size; i++){
            for(int j = 0; j < board_size; j++){
                buttons[i][j] = new Button(i,j,board, this);
            }
        }
    }

    public void updateAllButtons() {
        for (int i = 0; i < board.board_size; i++) {
            for (int j = 0; j < board.board_size; j++) {
                buttons[i][j].update();
            }
        }
    }

    public void updateGUI() {
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if (board.revealed_array[i][j]) {
                    if (board.value_array[i][j] == -1) {
                        buttons[i][j].setText("*");
                        buttons[i][j].setBackground(Color.RED);
                        buttons[i][j].setForeground(Color.BLACK);
                    }
                    else if (board.value_array[i][j] == 0) {
                        buttons[i][j].setText("-");
                        buttons[i][j].setBackground(Color.decode("#7FB3D5"));
                        buttons[i][j].setForeground(Color.BLACK);
                    }
                    else {
                        buttons[i][j].setText(String.valueOf(board.value_array[i][j]));
                        buttons[i][j].setBackground(Color.decode("#5499C7"));
                    }
                    buttons[i][j].setEnabled(false);
                }
            }
        }
    }
    
}

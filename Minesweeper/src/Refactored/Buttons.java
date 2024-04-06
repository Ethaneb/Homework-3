package Refactored;

public class Buttons {
    int board_size;
    Button[][] buttons = new Button[board_size][board_size];

    public Buttons(int board_size){
        this.board_size = board_size;
        for(int i = 0; i < board_size; i++){
            for(int j = 0; j < board_size; j++){
                buttons[i][j] = new Button(i,j);
            }
        }
    }
    
}

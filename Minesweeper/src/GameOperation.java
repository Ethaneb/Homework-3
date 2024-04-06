

public class GameOperation {
    Board board;
    int board_size;
    Buttons buttons;

    public GameOperation(Board board, Buttons buttons){
        this.buttons = buttons;
        this.board = board;
        this.board_size = board.board_size;

    }


    public void processClick(int x, int y, int type) {
        
        if (type == 0) {
            
            leftClick(x, y);
        } 
        else if (type == 1) {
            
            toggleFlag(x, y);
        }
    }

    public void leftClick(int x, int y) {
        revealCell(x, y);
        GameStatus gameStatus = new GameStatus(board);
        gameStatus.checkGameStatus();

        if (gameStatus.current == gameStatus.win) {
            congratulations();
        }
        else if (gameStatus.current == gameStatus.game_over) {
            gameOver();
        }
    }
    
    public void revealCell(int x, int y) {
        // Ensure the cell can be revealed
        if (x < 0 || x >= board_size || y < 0 || y >= board_size || board.revealed_array[x][y]) {
            return;
        }

        board.revealed_array[x][y] = true;
        buttons.buttons[x][y].update();
    
        if (board.value_array[x][y] == 0) {
            // Recursively reveal adjacent cells if they are empty
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {

                    if (i < 0 || i >= board_size || j < 0 || j >= board_size || board.revealed_array[i][j]) {
                        continue;
                    }
                    else {
                        if(board.value_array[i][j] >= 0){
                            revealCell(i, j);
                        }

                    }
                }
            }
        }
        buttons.updateGUI();
    }



    private void toggleFlag(int x, int y) {
        // If the cell has already been revealed, it can't be flagged
        if (board.revealed_array[x][y]) {
            return;
        }
        // Toggle the flag status of the cell
        board.flag_array[x][y] = !board.flag_array[x][y];
        // Update the display to show or hide the flag
        if (board.flag_array[x][y]) {
            buttons.buttons[x][y].setText("F");
        } else {
            buttons.buttons[x][y].setText("");
        }
    }

    public void congratulations(){
        DialogBox dialogBox = new DialogBox("Congratulations","Congratulations! You have won!");
        buttons.updateAllButtons();
        board.revealBoard();
        dialogBox.show();
        System.exit(0);
    }



    public void gameOver(){
        DialogBox dialogBox = new DialogBox("Game Over","Game Over! You hit a mine!");
        board.revealBoard();
        buttons.updateAllButtons();
        dialogBox.show();
        System.exit(0);
        } 
  
}

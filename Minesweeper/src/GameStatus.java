

public class GameStatus {
    Board board;
    int playing = 0;
    int game_over = -1;
    int win = 1;
    int current = playing;

    public GameStatus(Board board){
        this.board = board;
    }

    public int checkGameStatus(){
        if(this.current == this.playing){
            check_win();
            check_lose();
        }
        return this.current;
    }

    public void check_win(){
        for (int i = 0; i < board.board_size; i++) {
            for (int j = 0; j < board.board_size; j++) {
                // If the cell is not a mine and has not been revealed, the game is not won
                if (board.value_array[i][j] != -1 && !board.revealed_array[i][j]) {
                    return;
                }
            }
        }
        this.current = this.win;
    }

    public void check_lose(){
        for (int i = 0; i < board.board_size; i++) {
            for (int j = 0; j < board.board_size; j++) {
                // If a mine is revealed, the game is lost
                if (board.value_array[i][j] == -1 && board.revealed_array[i][j]) {
                    this.current = this.game_over;
                    return;
                }
            }
        }
    }
    
}

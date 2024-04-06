

public class Board {
    public int board_size; // Size of the board
    public int number_of_mines; // Number of mines

    int bomb = -1;
    int empty = 0;

    // Layers of the board
    private char[][] board_array;
    public int[][] value_array;
    public Boolean[][] revealed_array;
    public Boolean[][] flag_array;

    //Constructor
    public Board(int board_size, int number_of_mines){
        this.board_size = board_size;
        this.number_of_mines = number_of_mines;
        this.board_array = new char[this.board_size][this.board_size];
        this.value_array = new int[this.board_size][this.board_size];
        this.revealed_array = new Boolean[this.board_size][this.board_size];
        this.flag_array = new Boolean[this.board_size][this.board_size];

        initializeBoard();
        placeMines();
        generate_next_to_bomb_values();

    }

     // Generate the board
    private void initializeBoard(){
        for(int i = 0; i < this.board_size; i++){
            for(int j = 0; j < this.board_size; j++){
                this.board_array[i][j] = '-';
                this.value_array[i][j] = 0;
                this.revealed_array[i][j] = false;
                this.flag_array[i][j] = false;
            }
        }
    }

    // Place mines on the board
    private void placeMines(){
        for(int i = 0; i < this.number_of_mines; i++){
            int x = (int)(Math.random() * this.board_size);
            int y = (int)(Math.random() * this.board_size);

            if(this.value_array[x][y] == -1){
                i--;
            }else{
                this.value_array[x][y] = -1;
            }
        }
    }


    // Generate the values of the cells next to the bombs
    private void generate_next_to_bomb_values(){
        for(int i = 0; i < this.board_size; i++){
            for(int j = 0; j < this.board_size; j++){

                if(isBomb(i, j)){
                    // Checking all 8 directions
                    for(int x = -1; x <= 1; x++){
                        for(int y = -1; y <= 1; y++){
                            if(legalMove(i+x, j+y)){
                                if(isBomb(i+x, j+y)==false){
                                    this.value_array[i + x][j + y]++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public Boolean legalMove(int x, int y){
        if(x >= 0 && x < this.board_size && y >= 0 && y < this.board_size){
            return true;
        }
        return false;
    }

    public Boolean isBomb(int x, int y){
        if(this.value_array[x][y] == bomb){
            return true;
        }
        return false;
    }

    public void revealBoard() {
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                revealed_array[i][j] = true;
            }
        }
    }

    
}

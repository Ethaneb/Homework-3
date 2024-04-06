

import javax.swing.*;


public class Refactored_Minesweeper {
    
        public Refactored_Minesweeper() {
            

            // Get the number of mines and the board size from the user

            String inputMines = JOptionPane.showInputDialog("Enter the number of mines:");
            int mine_count = Integer.parseInt(inputMines);
    
            String inputSize = JOptionPane.showInputDialog("Enter board length/width:");
            int board_size = Integer.parseInt(inputSize);


            // Create the board, buttons, and display
            Board board = new Board(board_size, mine_count);
            
            Buttons buttons = new Buttons(board.board_size, board);
           
            Display display = new Display(board_size, mine_count, buttons);
        }
    
        
        public static void main(String[] args) {
            SwingUtilities.invokeLater(Refactored_Minesweeper::new);
        }
}

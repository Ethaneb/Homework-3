

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Button extends javax.swing.JButton{
    int dimension = 50;
    int row;
    int col;
    Board board;
    Buttons buttons;

    public Button(int row,int col, Board board, Buttons buttons){
        this.board = board;
        this.row = row;
        this.col = col;
        this.buttons = buttons;
        this.setPreferredSize(new Dimension(dimension, dimension));
        this.addMouseListener();
        this.setBackground(Color.decode("#CBDEEA"));
    }

    public void update(){
        int value = board.value_array[row][col];
        if(value == -1){
            this.setText("X");
            this.setBackground(Color.RED);
        }
        else if(value == 0){
            this.setText("-");
            this.setBackground(Color.decode("#7FB3D5"));
        }
        else{
            this.setText(String.valueOf(value));
            this.setBackground(Color.decode("#5499C7"));
        }
        this.setEnabled(false); 
        
    }

    private void addMouseListener(){
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    GameOperation operation = new GameOperation(board, buttons);
                    operation.processClick(row, col, 0);
                    //operation.revealCell(row, col);
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    GameOperation operation = new GameOperation(board, buttons);
                    operation.processClick(row, col, 1);
                    
                }}});
    }
    
    



}

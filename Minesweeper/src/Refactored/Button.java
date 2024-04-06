package Refactored;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Button extends javax.swing.JButton{
    int dimension = 50;
    int row;
    int col;

    public Button(int row,int col){
        this.row = row;
        this.col = col;
        this.setPreferredSize(new Dimension(dimension, dimension));
        this.addMouseListener();
        this.setBackground(Color.decode("#CBDEEA"));
    }


    private void addMouseListener(){
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    left_click();  
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    right_click();
                }}});
    }

    public void left_click(){
        //revealCell(row, col);
        //updateGUI();
    }

    public void right_click(){
        //toggleFlag(row, col);
        //updateGUI();
    }
}

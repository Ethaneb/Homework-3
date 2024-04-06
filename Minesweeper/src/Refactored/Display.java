package Refactored;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;

public class Display {
    Board board;
    String title = "Minesweeper";
    String timer_title = "Time:";
    String mine_count_title = "Time:";

    Display(Board board){
        this.board = board;
        javax.swing.JFrame frame = new javax.swing.JFrame(this.title);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        addHeader();

        frame.setLayout(new java.awt.BorderLayout());
        frame.setVisible(true);
    }


    private void addHeader(){
        javax.swing.JPanel header = new javax.swing.JPanel();
        JLabel heading = new JLabel("Minesweeper", SwingConstants.CENTER);
        heading.setFont(new Font("IMPACT", Font.ITALIC, 5*board.board_size));
        heading.setOpaque(true);
        heading.setBackground(Color.decode("#1F618D"));
        heading.setForeground(Color.decode("#EAF2F8"));
        header.add(heading,BorderLayout.NORTH);
    }

    private void addButtons(){
        
    }

    
}

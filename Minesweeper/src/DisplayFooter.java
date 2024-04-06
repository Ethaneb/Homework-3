

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.*;


public class DisplayFooter {
    int board_size;
    JLabel timer;
    JLabel counter;
    JPanel footer;

    public DisplayFooter(Color background_color, Color foreground_color, int board_size, int mineCount){
        footer = new JPanel(new GridLayout(1, 2));
        counter = addMineCount(mineCount, background_color, foreground_color);
        timer = addTimer(background_color, foreground_color);

        footer.add(counter,BorderLayout.SOUTH);
        footer.add(timer,BorderLayout.SOUTH);

    }


    private JLabel addMineCount(int mineCount, Color background_color, Color foreground_color){
        JLabel mineCountLabel = new JLabel("Mines: 0", SwingConstants.CENTER);
        mineCountLabel.setFont(new Font("Impact", Font.PLAIN, 3*board_size));
        mineCountLabel.setOpaque(true);
        mineCountLabel.setBackground(background_color);
        mineCountLabel.setForeground(foreground_color);
        return mineCountLabel;
    }
    
    private JLabel addTimer(Color background_color, Color foreground_color){
        JLabel timerLabel = new JLabel("Time: 0", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Impact", Font.PLAIN, 3*board_size));;
        timerLabel.setOpaque(true);
        timerLabel.setBackground(background_color);
        timerLabel.setForeground(foreground_color);
        return timerLabel;
    }


    
}

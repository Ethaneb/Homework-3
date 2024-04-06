

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.*;

public class Display {
    String title = "Minesweeper";
    String timer_title = "Time: 0";
    String mine_count_title = "Mines:";

    Color background_color = Color.decode("#1F618D");
    Color foreground_color = Color.decode("#EAF2F8");

    DisplayHeader header;
    DisplayView view;
    DisplayFooter footer;
    JFrame frame;

    Display(int board_size, int mine_count, Buttons buttons){
        
        frame = new JFrame(this.title);
        frame.setLayout(new BorderLayout());

        header = new DisplayHeader(background_color, foreground_color, title, board_size);
        frame.add(header.getHeading(), BorderLayout.NORTH);

        view = new DisplayView(board_size, buttons);
        frame.add(view.buttonPanel, BorderLayout.CENTER);

        footer = new DisplayFooter(background_color, foreground_color, board_size, mine_count);
        frame.add(footer.footer, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new Timer(1000, e -> {
            footer.timer = new JLabel(timer_title, SwingConstants.CENTER);
            String time = footer.timer.getText();
            int seconds = Integer.parseInt(time.substring(6));
            footer.timer.setText("Time: " + (seconds + 1));
        }).start();
        
        frame.pack();
        frame.setVisible(true);
    }

  
}

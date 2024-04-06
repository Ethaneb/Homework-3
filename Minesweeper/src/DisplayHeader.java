

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.*;

public class DisplayHeader {
    JPanel header;
    JLabel heading;


    public DisplayHeader(Color background_color, Color foreground_color, String title, int board_size){
        header = new JPanel();
        heading = new JLabel("Minesweeper", SwingConstants.CENTER);
        heading.setFont(new Font("IMPACT", Font.ITALIC, 5*board_size));
        heading.setOpaque(true);
        heading.setBackground(background_color);
        heading.setForeground(foreground_color);
        header.add(heading,BorderLayout.NORTH);
    }

    public JPanel getHeader(){
        return this.header;
    }
    
    public JLabel getHeading(){
        return this.heading;
    }
    
}

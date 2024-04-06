

import javax.swing.*;
import java.awt.*;


public class DisplayView {
    int board_size;
    Buttons buttons;
    JPanel buttonPanel;

    public DisplayView(int board_size, Buttons buttons){
        this.buttons = buttons;
        this.board_size = board_size;
        buttonPanel = new JPanel(new GridLayout(board_size, board_size));
        setButtons(buttonPanel);
    }

    private void setButtons(JPanel buttonPanel) {
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                buttonPanel.add(buttons.buttons[i][j]);
            }
        }
    }
    
}

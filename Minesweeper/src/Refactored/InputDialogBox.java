package Refactored;

public abstract class InputDialogBox extends DialogBox{
    int input;
    public void show(){
        String answer = javax.swing.JOptionPane.showInputDialog(null, this.message, this.title, javax.swing.JOptionPane.PLAIN_MESSAGE);
        
        try{
            this.input = Integer.parseInt(answer);   

        }catch(NumberFormatException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            this.show();
        }
    }
}

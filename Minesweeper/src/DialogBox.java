

public class DialogBox extends javax.swing.JDialog{
    String title;
    String message;

    public DialogBox(String title, String message){
        this.title = title;
        this.message = message;
    }
    public void show(){
        javax.swing.JOptionPane.showMessageDialog(null, title, message, javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
}

package Refactored;

public abstract class DialogBox extends javax.swing.JDialog{
    String title;
    String message;
    public abstract void show(String message);
}

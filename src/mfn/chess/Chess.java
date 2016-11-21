package mfn.chess;


import javax.swing.*;

public class Chess {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

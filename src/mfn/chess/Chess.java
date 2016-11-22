package mfn.chess;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Fyodor
 */
public class Chess {
    private static final int WINDOW_WIDTH = 519;
    private static final int WINDOW_HEIGHT = 542;

    static String[][] chessBoard = {
            {"r", "k", "b", "q", "a", "b", "k", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "K", "B", "Q", "A", "B", "K", "R"},
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UserInterface ui = new UserInterface();
        frame.add(ui);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - WINDOW_WIDTH) / 2;
        int y = (dim.height - WINDOW_HEIGHT) / 2;
        frame.setLocation(x, y);
        ImageIcon icon = new ImageIcon("img/icon.jpg");
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

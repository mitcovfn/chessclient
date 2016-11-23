package mfn.chess;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Fyodor
 */
public class Chess {
    private static final int WINDOW_WIDTH = 519;
    private static final int WINDOW_HEIGHT = 542;

    static int kingPositionC, kingPositionL;

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
//        JFrame frame = new JFrame("Chess");
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        UserInterface ui = new UserInterface();
//        frame.add(ui);
//        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = (dim.width - WINDOW_WIDTH) / 2;
//        int y = (dim.height - WINDOW_HEIGHT) / 2;
//        frame.setLocation(x, y);
//        ImageIcon icon = new ImageIcon("img/icon.jpg");
//        frame.setIconImage(icon.getImage());
//        frame.setResizable(false);
//        frame.setVisible(true);
        System.out.println(posibleMoves());
    }

    public static String posibleMoves() {
        String list = "";
        for (int i = 0; i < 64; i++) {
            switch (chessBoard[i / 8][i % 8]) {
                case "P":
                    list += posibleP(i);
                    break;
                case "R":
                    list += posibleR(i);
                    break;
                case "K":
                    list += posibleK(i);
                    break;
                case "B":
                    list += posibleB(i);
                    break;
                case "Q":
                    list += posibleQ(i);
                    break;
                case "A":
                    list += posibleA(i);
                    break;
            }
        }
        return list; //x1-y1, x2-y2
    }

    public static String posibleP(int i) {
        String list = "";
        return list;
    }

    public static String posibleR(int i) {
        String list = "";
        return list;
    }

    public static String posibleK(int i) {
        String list = "";
        return list;
    }

    public static String posibleB(int i) {
        String list = "";
        return list;
    }
    //Queen Movement
    public static String posibleQ(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        int temp=1;
        for (int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {
                try {
                    while (" ".equals(chessBoard[r+temp*j][c+temp*k])){
                        oldPiece = chessBoard[r+temp*j][c+temp*k];
                        chessBoard[r][c]= " ";
                        chessBoard[r+temp*j][c+temp*k] = "Q";
                        if (kingSafe()) {
                            list = list + r + c + (r+temp*j) + (c+temp*k) + oldPiece;
                        }
                        chessBoard[r][c]= "Q";
                        chessBoard[r+temp*j][c+temp*k] = oldPiece;
                        temp++;
                    }
                    if(Character.isLowerCase(chessBoard[r+temp*j][c+temp*k].charAt(0))){
                        oldPiece = chessBoard[r+temp*j][c+temp*k];
                        chessBoard[r][c]= " ";
                        chessBoard[r+temp*j][c+temp*k] = "Q";
                        if (kingSafe()) {
                            list = list + r + c + (r+temp*j) + (c+temp*k) + oldPiece;
                        }
                        chessBoard[r][c]= "Q";
                        chessBoard[r+temp*j][c+temp*k] = oldPiece;
                    }
                }catch (Exception e){}
                temp=1;
            }
        }
        return list;
    }

    //King Movement
    public static String posibleA(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        for (int j = 0; j < 9; j++) {
            if (j != 4) {
                try {
                    if (Character.isLowerCase(chessBoard[r - 1 + j / 3][c - 1 + j % 3].charAt(0)) || " ".equals(chessBoard[r - 1 + j / 3][c - 1 + j % 3])) {
                        oldPiece = chessBoard[r - 1 + j / 3][c - 1 + j % 3];
                        chessBoard[r][c] = " ";
                        chessBoard[r - 1 + j / 3][c - 1 + j % 3] = "A";
                        int kingTemp = kingPositionC;
                        kingPositionC = i + (j / 3) * 8 + j % 3 - 9;
                        if (kingSafe()) {
                            list = list + r + c + (r - 1 + j / 3) + (c - 1 + j % 3) + oldPiece;
                        }
                        chessBoard[r][c] = "A";
                        chessBoard[r - 1 + j / 3][c - 1 + j % 3] = oldPiece;
                        kingPositionC = kingTemp;
                    }
                } catch (Exception e) {
                }
            }
        }
        return list;
    }

    public static boolean kingSafe() {
        return true;
    }
}

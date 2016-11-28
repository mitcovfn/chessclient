package mfn.chess;


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
            {" ", " ", " ", " ", " ", " ", "q", " "},
            {" ", " ", " ", " ", " ", " ", " ", "k"},
            {" ", " ", " ", " ", "A", " ", " ", " "},
            {"P", "P", "P", "P", "P", "P", "P", " "},
            {"R", "K", "B", "Q", " ", "B", "K", "R"},
    };

    public static void main(String[] args) {
        while (!"A".equals(chessBoard[kingPositionC / 8][kingPositionC % 8])) {
            kingPositionC++;
        } //get king's location
        while (!"a".equals(chessBoard[kingPositionL / 8][kingPositionL % 8])) {
            kingPositionL++;
        } //get king's location
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

    //Rook Movement
    public static String posibleR(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        int temp = 1;
        for (int j = -1; j <= 1; j += 2) {
            try {
                while (" ".equals(chessBoard[r][c + temp * j])) {
                    oldPiece = chessBoard[r][c + temp * j];
                    chessBoard[r][c] = " ";
                    chessBoard[r][c + temp * j] = "R";
                    if (kingSafe()) {
                        list = list + r + c + r + (c + temp * j) + oldPiece;
                    }
                    chessBoard[r][c] = "R";
                    chessBoard[r][c + temp * j] = oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(chessBoard[r][c + temp * j].charAt(0))) {
                    oldPiece = chessBoard[r][c + temp * j];
                    chessBoard[r][c] = " ";
                    chessBoard[r][c + temp * j] = "R";
                    if (kingSafe()) {
                        list = list + r + c + r + (c + temp * j) + oldPiece;
                    }
                    chessBoard[r][c] = "R";
                    chessBoard[r][c + temp * j] = oldPiece;
                }
            } catch (Exception e) {
            }
            temp = 1;
            try {
                while (" ".equals(chessBoard[r + temp * j][c])) {
                    oldPiece = chessBoard[r + temp * j][c];
                    chessBoard[r][c] = " ";
                    chessBoard[r + temp * j][c] = "R";
                    if (kingSafe()) {
                        list = list + r + c + (r + temp * j) + c + oldPiece;
                    }
                    chessBoard[r][c] = "R";
                    chessBoard[r + temp * j][c] = oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(chessBoard[r + temp * j][c].charAt(0))) {
                    oldPiece = chessBoard[r + temp * j][c];
                    chessBoard[r][c] = " ";
                    chessBoard[r + temp * j][c] = "R";
                    if (kingSafe()) {
                        list = list + r + c + (r + temp * j) + c + oldPiece;
                    }
                    chessBoard[r][c] = "R";
                    chessBoard[r + temp * j][c] = oldPiece;
                }
            } catch (Exception e) {
            }
            temp = 1;
        }
        return list;
    }

    //Knight movement (Horse)
    public static String posibleK(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                try {
                    if (Character.isLowerCase(chessBoard[r + j][c + k * 2].charAt(0)) || " ".equals(chessBoard[r + j][c + k * 2])) {
                        oldPiece = chessBoard[r + j][c + k * 2];
                        chessBoard[r][c] = " ";
                        //chessBoard[r + j][c + k * 2] ="K";
                        if (kingSafe()) {
                            list = list + r + c + (r + j) + (c + k * 2) + oldPiece;
                        }
                        chessBoard[r][c] = "K";
                        chessBoard[r + j][c + k * 2] = oldPiece;
                    }
                } catch (Exception e) {
                }

                try {
                    if (Character.isLowerCase(chessBoard[r + j * 2][c + k].charAt(0)) || " ".equals(chessBoard[r + j * 2][c + k])) {
                        oldPiece = chessBoard[r + j * 2][c + k];
                        chessBoard[r][c] = " ";
                        //chessBoard[r + j][c + k * 2] ="K";
                        if (kingSafe()) {
                            list = list + r + c + (r + j * 2) + (c + k) + oldPiece;
                        }
                        chessBoard[r][c] = "K";
                        chessBoard[r + j * 2][c + k] = oldPiece;
                    }
                } catch (Exception e) {
                }
            }
        }
        return list;
    }

    //Bishop Movement
    public static String posibleB(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        int temp = 1;
        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                try {
                    while (" ".equals(chessBoard[r + temp * j][c + temp * k])) {
                        oldPiece = chessBoard[r + temp * j][c + temp * k];
                        chessBoard[r][c] = " ";
                        chessBoard[r + temp * j][c + temp * k] = "B";
                        if (kingSafe()) {
                            list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                        }
                        chessBoard[r][c] = "B";
                        chessBoard[r + temp * j][c + temp * k] = oldPiece;
                        temp++;
                    }
                    if (Character.isLowerCase(chessBoard[r + temp * j][c + temp * k].charAt(0))) {
                        oldPiece = chessBoard[r + temp * j][c + temp * k];
                        chessBoard[r][c] = " ";
                        chessBoard[r + temp * j][c + temp * k] = "B";
                        if (kingSafe()) {
                            list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                        }
                        chessBoard[r][c] = "B";
                        chessBoard[r + temp * j][c + temp * k] = oldPiece;
                    }
                } catch (Exception e) {
                }
                temp = 1;
            }
        }
        return list;
    }

    //Queen Movement
    public static String posibleQ(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        int temp = 1;
        for (int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {
                if (j != 0 || k != 0) {
                    try {
                        while (" ".equals(chessBoard[r + temp * j][c + temp * k])) {
                            oldPiece = chessBoard[r + temp * j][c + temp * k];
                            chessBoard[r][c] = " ";
                            chessBoard[r + temp * j][c + temp * k] = "Q";
                            if (kingSafe()) {
                                list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                            }
                            chessBoard[r][c] = "Q";
                            chessBoard[r + temp * j][c + temp * k] = oldPiece;
                            temp++;
                        }
                        if (Character.isLowerCase(chessBoard[r + temp * j][c + temp * k].charAt(0))) {
                            oldPiece = chessBoard[r + temp * j][c + temp * k];
                            chessBoard[r][c] = " ";
                            chessBoard[r + temp * j][c + temp * k] = "Q";
                            if (kingSafe()) {
                                list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                            }
                            chessBoard[r][c] = "Q";
                            chessBoard[r + temp * j][c + temp * k] = oldPiece;
                        }
                    } catch (Exception e) {
                    }
                    temp = 1;
                }
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
        //bishop/queen
        int temp = 1;
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                try {
                    while (" ".equals(chessBoard[kingPositionC / 8 + temp * i][kingPositionC % 8 + temp * j])) {
                        temp++;
                    }
                    if ("b".equals(chessBoard[kingPositionC / 8 + temp * i][kingPositionC % 8 + temp * j]) ||
                            "q".equals(chessBoard[kingPositionC / 8 + temp * i][kingPositionC % 8 + temp * j])) {
                        //danger
                        return false;

                    }
                } catch (Exception e) {
                }
                temp = 1;
            }
        }

        //rook/quenn
        for (int i = -1; i <= 1; i += 2) {
            try {
                while (" ".equals(chessBoard[kingPositionC / 8][kingPositionC % 8 + temp * i])) {
                    temp++;
                }
                if ("r".equals(chessBoard[kingPositionC / 8][kingPositionC % 8 + temp * i]) ||
                        "q".equals(chessBoard[kingPositionC / 8][kingPositionC % 8 + temp * i])) {
                    //danger
                    return false;

                }
            } catch (Exception e) {
            }
            temp = 1;
            try {
                while (" ".equals(chessBoard[kingPositionC / 8 + temp * i][kingPositionC % 8])) {
                    temp++;
                }
                if ("r".equals(chessBoard[kingPositionC / 8 + temp * i][kingPositionC % 8]) ||
                        "q".equals(chessBoard[kingPositionC / 8 + temp * i][kingPositionC % 8])) {
                    //danger
                    return false;

                }
            } catch (Exception e) {
            }
            temp = 1;
        }

        //knight
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                try {
                    if ("k".equals(chessBoard[kingPositionC / 8 + i][kingPositionC % 8 + j * 2])) {
                        //danger
                        return false;

                    }
                } catch (Exception e) {
                }
                try {
                    if ("k".equals(chessBoard[kingPositionC / 8 + i * 2][kingPositionC % 8 + j])) {
                        //danger
                        return false;
                    }
                } catch (Exception e) {
                }
            }
        }

        //pawn
        if (kingPositionC >= 16) {
            try {
                if ("p".equals(chessBoard[kingPositionC / 8 - 1][kingPositionC % 8 - 1])) {
                    //danger
                    return false;
                }
            } catch (Exception e) {
            }
            try {
                if ("p".equals(chessBoard[kingPositionC / 8 - 1][kingPositionC % 8 + 1])) {
                    //danger
                    return false;
                }
            } catch (Exception e) {
            }

            //king
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        try {
                            if ("a".equals(chessBoard[kingPositionC / 8 + i][kingPositionC % 8 + j])) {
                                //danger
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }


        return true;
    }
}

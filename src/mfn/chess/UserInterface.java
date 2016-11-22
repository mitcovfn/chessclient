package mfn.chess;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Fyodor
 */
class UserInterface extends JPanel {

    private static final int CELL_WIDTH = 64;
    private static final int CELL_HEIGHT = 64;
    private Image chessPieces = new ImageIcon("img/chessPieces.png").getImage();

    public UserInterface() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawPieces(g);
    }

    private void drawBoard(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                if ((i + j) % 2 == 0) {
                    g.setColor(new Color(251, 231, 209));
                    g.fillRect(i * CELL_WIDTH, j * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                } else {
                    g.setColor(new Color(211, 141, 83));
                    g.fillRect(i * CELL_WIDTH, j * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                }
        }
    }

    private void drawPieces(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (Chess.chessBoard[j][i]) {
                    case "R":
                        drawPiece(g, i, j, 0, 6, 235, 312);
                        break;
                    case "K":
                        drawPiece(g, i, j, 303, 12, 616, 307);
                        break;
                    case "B":
                        drawPiece(g, i, j, 643, 0, 988, 320);
                        break;
                    case "Q":
                        drawPiece(g, i, j, 1343, 13, 1668, 305);
                        break;
                    case "A":
                        drawPiece(g, i, j, 1015, 11, 1311, 297);
                        break;
                    case "P":
                        drawPiece(g, i, j, 2120, 35, 2313, 323);
                        break;
                    case "r":
                        drawPiece(g, i, j, 0, 395, 235, 701);
                        break;
                    case "k":
                        drawPiece(g, i, j, 303, 405, 616, 698);
                        break;
                    case "b":
                        drawPiece(g, i, j, 651, 389, 989, 705);
                        break;
                    case "q":
                        drawPiece(g, i, j, 1345, 404, 1668, 693);
                        break;
                    case "a":
                        drawPiece(g, i, j, 1018, 413, 1309, 694);
                        break;
                    case "p":
                        drawPiece(g, i, j, 2121, 415, 2311, 701);
                        break;
                }
            }
        }
    }

    private void drawPiece(Graphics g, int i, int j, int x1, int y1, int x2, int y2) {
        g.drawImage(chessPieces,
                (i * CELL_WIDTH) + 5, (j * CELL_HEIGHT) + 5, (CELL_WIDTH * (i + 1)) - 5, (CELL_HEIGHT * (j + 1)) - 5,
                x1, y1, x2, y2, this);
    }
}

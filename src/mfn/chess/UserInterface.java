package mfn.chess;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Fyodor
 */
class UserInterface extends JPanel {

    private static final int CELL_WIDTH = 64;
    private static final int CELL_HEIGHT = 64;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
    }

    private void drawBoard(Graphics g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(i * CELL_WIDTH, j * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                } else {
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(i * CELL_WIDTH, j * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                }
        }
    }
}

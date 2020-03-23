package dev.shroysha.digitalclock.model;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class DigitalClockDomino extends JComponent {

    public static final int DOT_WIDTH = 10, DOT_HEIGHT = 10;
    public static final int[][][] DISPLAY_DOT = new int[][][] {
            new int[][] {
                    new int[]{1, 1},
            },
            new int[][] {
                    new int[]{0, 0},
                    new int[]{2, 2}
            },
            new int[][] {
                    new int[]{0, 0},
                    new int[]{1, 1},
                    new int[]{2, 2}
            },
            new int[][] {
                    new int[]{0, 0},
                    new int[]{2, 0},
                    new int[]{0, 2},
                    new int[]{2, 2}
                    },
            new int[][] {
                    new int[]{0, 0},
                    new int[]{2, 0},
                    new int[]{0, 2},
                    new int[]{1, 1},
                    new int[]{2, 2}
            },
            new int[][] {
                    new int[]{0, 0},
                    new int[]{1, 0},
                    new int[]{2, 0},
                    new int[]{0, 2},
                    new int[]{1, 1},
                    new int[]{2, 2}
            }
    };

    @Getter
    private final Point[][] dots = new Point[6][3]; // 0 is top
    @Setter @Getter
    private int currentNum;

    public DigitalClockDomino() {
        super();
        repositionDots();
    }

    public void repositionDots() {
        int dotSeparation = 30;

        for(int i = 0; i < dots.length; i++) {
            for(int j = 0; j < dots[i].length; j++) {
                dots[i][j] = new Point(
                        i * dotSeparation,
                        j * dotSeparation);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.draw(this.getBounds());
        g2d.setColor(Color.DARK_GRAY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < dots.length; i++) {
            for (int j = 0; j < dots[i].length; j++) {
                if(shouldDisplayDot(i, j)) {
                    Point dot = dots[i][j];
                    g2d.fillOval(dot.x, dot.y, DOT_WIDTH, DOT_HEIGHT);
                }
            }
        }

    }

    public boolean shouldDisplayDot(int i, int j) {
        for(int[] row : DISPLAY_DOT[currentNum]) {
            if(row[0] == i && row[1] == j) {
                return true;
            }
        }
        return false;
    }

}

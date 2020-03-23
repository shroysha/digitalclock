package dev.shroysha.digitalclock.views;

import dev.shroysha.digitalclock.model.DigitalClockDomino;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class DigitalClockFrame extends JFrame {

    public final DigitalClockDomino[] dominoes = new DigitalClockDomino[3];

        public DigitalClockFrame() {
            super();
            init();
        }

        private void init() {
            Arrays.fill(dominoes, new DigitalClockDomino());
            this.setBackground(Color.blue);
            this.setBounds(50, 50, 400, 275);
            reshapeDominoes();
        }

        private void reshapeDominoes() {
            Dimension dim = this.getSize();
            final int heightBuff = (int) (dim.getHeight() / 20);
            final int widthBuff = (int) (dim.getWidth() / 20);
            final int remWidth = (int) (dim.getWidth() - (widthBuff * 4));
            final int remHeight = (int) (dim.getHeight() - heightBuff * 2);

            final int dominoWidth = remWidth / 3;


            int x = widthBuff;
            for (DigitalClockDomino domino : dominoes) {
                domino.setBounds(new Rectangle(x, heightBuff, dominoWidth, remHeight));
                x += dominoWidth + widthBuff;
            }

        }


}

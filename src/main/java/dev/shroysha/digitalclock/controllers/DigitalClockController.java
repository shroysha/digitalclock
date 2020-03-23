package dev.shroysha.digitalclock.controllers;

import dev.shroysha.digitalclock.views.DigitalClockFrame;

import java.util.Calendar;

public class DigitalClockController {

    private final DigitalClockFrame frame;

    public DigitalClockController(DigitalClockFrame frame) {
        this.frame = frame;
    }

    public void updateClock() {
        Calendar cal = Calendar.getInstance();
        frame.dominoes[0].setCurrentNum(cal.get(Calendar.HOUR));
        frame.dominoes[1].setCurrentNum(cal.get(Calendar.MINUTE) / 10);
        frame.dominoes[2].setCurrentNum(cal.get(Calendar.MINUTE) % 10);

        frame.getContentPane().repaint();
    }
}

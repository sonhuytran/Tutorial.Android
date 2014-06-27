package com.sonhuytran.robosohu.ui;

/**
 * @author Son-Huy
 * @version 1.0 (25/06/2014)
 */
public class BackgroundUI {

    /**
     *
     */
    private int bgX;

    /**
     *
     */
    private int bgY;

    /**
     *
     */
    private int speedX;


    public int getBgX() {
        return bgX;
    }

    public int getBgY() {
        return bgY;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    /**
     * @param x
     * @param y
     */
    public BackgroundUI(int x, int y) {
        bgX = x;
        bgY = y;
        speedX = 0;
    }

    public void update() {
        bgX += speedX;

        if (bgX <= -2160) {
            bgX += 4320;
        }
    }
}
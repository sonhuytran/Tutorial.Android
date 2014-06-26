package com.sonhuytran.robosohu.ui;

/**
 * @author Son-Huy
 * @version 1.0 (25/06/2014)
 */
public class RobotUI {

    private int centerX = 100;
    private int centerY = 382;
    private boolean jumped = false;

    private int speedX = 0;
    private int speedY = 1;

    public void update() {

        // moves character or scrolls background accordingly
        if (speedX < 0) {
            centerX += speedX;
        } else if (speedX == 0) {
            // TODO: do not scroll the background
        } else {
            if (centerX <= 150) {
                centerX += speedX;
            } else {
                // TODO: scroll background here
            }
        }
    }
}

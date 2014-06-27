package com.sonhuytran.robosohu.ui;

/**
 * @author Son-Huy
 * @version 1.0 (25/06/2014)
 */
public class RobotUI {

    // region Constants

    private static final int JUMP_SPEED = -15;
    private static final int MOVE_SPEED = 5;
    private static final int GROUND = 382;

    // endregion

    private static BackgroundUI background1 = GameUI.getBackground1();
    private static BackgroundUI background2 = GameUI.getBackground2();

    /**
     * The x-coordinate of the robot character's centre
     */
    private int centerX = 100;

    /**
     * The y-coordinate of the robot character's centre
     */
    private int centerY = 382;

    /**
     * {@code true} if the character is in the air, {@code false} when grounded
     */
    private boolean jumped = false;

    /**
     *
     */
    private boolean movingLeft = false;

    /**
     *
     */
    private boolean movingRight = false;

    /**
     *
     */
    private boolean ducked = false;

    /**
     * the rate at which the x-position change
     */
    private int speedX = 0;

    /**
     * the rate at which the y-position change
     */
    private int speedY = 1;

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    private void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    private void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    /**
     * This method is called on each iteration of the game loop.
     */
    public void update() {

        // moves character or scrolls background accordingly

        // updates X position
        if (speedX < 0) {
            centerX += speedX;
        }

        if (speedX <= 0) {
            background1.setSpeedX(0);
            background2.setSpeedX(0);
        }

        if (centerX <= 200 && speedX > 0) {
            centerX += speedX;
        }

        if (centerX > 200 && speedX > 0) {
            background1.setSpeedX(-MOVE_SPEED);
            background2.setSpeedX(-MOVE_SPEED);
        }

        // updates Y position
        centerY += speedY;

        if (centerY + speedY >= GROUND) {
            centerY = GROUND;
        }

        // handles jumping
        if (jumped) {
            speedY++;

            if (centerY + speedY >= GROUND) {
                centerY = GROUND;
                speedY = 0;
                jumped = false;
            }
        }

        // prevents going beyond X coordinate of 0

    }

    public void moveRight() {
        if (!ducked) {
            speedX = MOVE_SPEED;
        }
    }

    public void moveLeft() {
        if (!ducked) {
            speedX = -MOVE_SPEED;
        }
    }

    private void stop() {
        if (isMovingLeft() && isMovingRight()) {
            //noinspection UnnecessaryReturnStatement
            return;
        } else if (!isMovingLeft() && !isMovingRight()) {
            speedX = 0;
        } else if (isMovingLeft()) {
            moveLeft();
        } else {
            moveRight();
        }
    }

    public void stopRight() {
        setMovingRight(false);
        stop();
    }

    public void stopLeft() {
        setMovingLeft(false);
        stop();
    }

    public void jump() {
        if (!jumped) {
            speedY = JUMP_SPEED;
            jumped = true;
        }
    }
}

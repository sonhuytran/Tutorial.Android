package com.sonhuytran.robosohu.ui;

import com.sonhuytran.robosohu.config.Config;
import com.sonhuytran.robosohu.config.Screen;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Son-Huy
 * @version 1.0 (25/06/2014)
 */
public class GameUI extends Applet implements Runnable, KeyListener {

    private Config config = null;
    private ImageResources imageResources;
    private RobotUI robot;
    private static BackgroundUI background1, background2;

    private Image image;
    private Image character;
    private Image background;
    private Graphics second;

    public static BackgroundUI getBackground1() {
        return background1;
    }

    public static BackgroundUI getBackground2() {
        return background2;
    }

// region Applet Implementation

    @Override
    public void init() {
        // Load the configurations
        config = Config.loadConfig(this);
        Screen screen = config.getScreen();

        // Initialize the resources
        imageResources = ImageResources.getInstance(this);

        // Set screen parameters
        setSize(screen.getWidth(), screen.getHeight());

        // Set the name of the window to the application name
        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle(config.getAppName());

        // Add key listener
        addKeyListener(this);

        // Other configs
        setBackground(Color.BLACK);
        setFocusable(true);

        super.init();
    }

    @Override
    public void start() {
        background1 = new BackgroundUI(0, 0);
        background2 = new BackgroundUI(2160, 0);
        robot = new RobotUI();

        character = imageResources.character();
        background = imageResources.background();

        Thread thread = new Thread(this);
        thread.start();

        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void update(Graphics g) {
        // Must comment this line because we are using double buffering.
        // super.update(g);

        if (null == image) {
            image = createImage(this.getWidth(), this.getHeight());
            second = image.getGraphics();
        }

        second.setColor(getBackground());
        second.fillRect(0, 0, getWidth(), getHeight());
        second.setColor(getForeground());
        paint(second);

        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {
        // Must comment this line because we are using double buffering.
        // super.paint(g);

        g.drawImage(background, background1.getBgX(), background1.getBgY(), this);
        g.drawImage(background, background2.getBgX(), background2.getBgY(), this);
        g.drawImage(character, robot.getCenterX() - 61, robot.getCenterY() - 63, this);
    }

    // endregion

    // region Runnable Implementation

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            robot.update();
            background1.update();
            background2.update();
            repaint();

            try {
                Thread.sleep(17); // 60 fps
            } catch (InterruptedException e) {
                // TODO: Handle exception
                e.printStackTrace();
            }
        }
    }

    // endregion

    // region KeyListener Implementation

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("Move up");
                break;

            case KeyEvent.VK_DOWN:
                System.out.println("Move down");
                break;

            case KeyEvent.VK_LEFT:
                robot.moveLeft();
                break;

            case KeyEvent.VK_RIGHT:
                robot.moveRight();
                break;

            case KeyEvent.VK_SPACE:
                robot.jump();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                System.out.println("Stop moving up");
                break;

            case KeyEvent.VK_DOWN:
                System.out.println("Stop moving down");
                break;

            case KeyEvent.VK_LEFT:
                robot.stopLeft();
                break;

            case KeyEvent.VK_RIGHT:
                robot.stopRight();
                break;

            case KeyEvent.VK_SPACE:
                System.out.println("Stop jumping");
                break;
        }
    }

    // endregion
}
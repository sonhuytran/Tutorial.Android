package com.sonhuytran.robosohu.ui;

import com.sonhuytran.robosohu.config.Config;
import com.sonhuytran.robosohu.config.Screen;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Son-Huy
 * @version 1.0 (25/06/2014)
 */
public class GameUI extends Applet implements Runnable, KeyListener {

    private Config config = null;

    // region Applet Implementation

    @Override
    public void init() {
        // Load the configurations
        config = Config.loadConfig(this);
        Screen screen = config.getScreen();

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

    // endregion

    // region Runnable Implementation

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
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
                System.out.println("Move left");
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("Move right");
                break;

            case KeyEvent.VK_SPACE:
                System.out.println("Jump");
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
                System.out.println("Stop moving left");
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("Stop moving right");
                break;

            case KeyEvent.VK_SPACE:
                System.out.println("Stop jumping");
                break;
        }
    }

    // endregion
}
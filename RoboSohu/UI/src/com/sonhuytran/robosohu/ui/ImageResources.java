package com.sonhuytran.robosohu.ui;

import java.applet.Applet;
import java.awt.Image;

/**
 * @author Huy
 * @version 1.0 (26/06/2014).
 */
public final class ImageResources extends Resources {

    private static final String IMAGES_FOLDER = "/resources/images/";
    private static final String IMAGE_BACKGROUND = "background.png";
    private static final String IMAGE_CHARACTER = "character.png";
    private static final String IMAGE_CHARACTER_DOWN = "down.png";
    private static final String IMAGE_CHARACTER_JUMPED = "jumped.png";

    protected ImageResources(Applet applet) {
        super(applet, IMAGES_FOLDER);
    }

    public static ImageResources getInstance(Applet applet) {
        return new ImageResources(applet);
    }

    private Image getImage(String imageName) {
        return applet.getImage(base, imageName);
    }

    public Image background() {
        return getImage(IMAGE_BACKGROUND);
    }

    public Image character() {
        return getImage(IMAGE_CHARACTER);
    }

    public Image characterDown() {
        return getImage(IMAGE_CHARACTER_DOWN);
    }

    public Image characterJumped() {
        return getImage(IMAGE_CHARACTER_JUMPED);
    }
}
package com.sonhuytran.robosohu.ui;

import java.applet.Applet;
import java.awt.*;

/**
 * @author Huy
 * @version 1.0 (26/06/2014).
 */
public final class ImageResources extends Resources {

    private static final String IMAGES_FOLDER = "/resources/images/";
    private static final String IMAGE_CHARACTER = "character.png";

    protected ImageResources(Applet applet) {
        super(applet, IMAGES_FOLDER);
    }

    public static ImageResources getInstance(Applet applet) {
        return new ImageResources(applet);
    }

    private Image getImage(String imageName) {
        return applet.getImage(base, imageName);
    }

    public Image character() {
        return getImage(IMAGE_CHARACTER);
    }
}
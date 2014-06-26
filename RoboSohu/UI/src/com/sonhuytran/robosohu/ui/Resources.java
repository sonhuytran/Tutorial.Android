package com.sonhuytran.robosohu.ui;

import java.applet.Applet;
import java.net.URL;

/**
 * @author Huy
 * @version 1.0 (26/06/2014).
 */
public abstract class Resources {

    // region Object scope

    protected URL base;
    protected Applet applet;

    protected Resources(Applet applet, String path) {
        base = applet.getClass().getResource(path);
    }

    // endregion
}
package com.sonhuytran.robosohu.config;

import com.google.gson.Gson;

import java.applet.Applet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Huy
 * @version 1.0 (26/06/2014).
 */
public class Config {
    private Screen screen;
    private String appName;

    public Screen getScreen() {
        return screen;
    }

    public String getAppName() {
        return appName;
    }

    public Config() {
    }

    public static Config loadConfig(Applet applet) {
        try {
            InputStream is = applet.getClass().getResourceAsStream("/resources/config/config.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;

            while (null != (line = br.readLine())) {
                sb.append(line);
            }

            br.close();
            is.close();

            Gson gson = new Gson();
            return gson.fromJson(sb.toString(), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Config();
    }
}

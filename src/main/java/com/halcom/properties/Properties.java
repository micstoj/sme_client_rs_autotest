package com.halcom.properties;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Properties {
    public static boolean robotThreadStarted = false;
    public static boolean isUrlLoaded = false;
    public static String getPropertyValue(String property, String propertyFile) {
        String value = null;

        try {
            java.util.Properties properties = new java.util.Properties();
            FileReader reader = new FileReader(propertyFile, StandardCharsets.UTF_8);
            properties.load(reader);

            value = properties.getProperty(property).trim();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return value;
    }
}

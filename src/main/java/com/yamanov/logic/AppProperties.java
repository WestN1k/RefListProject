package com.yamanov.logic;

import java.io.*;
import java.util.Properties;

public class AppProperties {
    private Properties properties;
    private final String APP_PROPERTY_FILE_NAME = "application.properties";

    public String getProperties(String key) {
        try(InputStream in = new FileInputStream(APP_PROPERTY_FILE_NAME)) {
            properties = new Properties();
            properties.load(in);
            return properties.getProperty(key);
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public String setProperties(String propName, String pattern) {
        try (OutputStream out = new FileOutputStream(APP_PROPERTY_FILE_NAME)){
            properties = new Properties();
            properties.setProperty(propName, pattern);
            properties.store(out, "pattern for " + propName);
            return "done";
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}

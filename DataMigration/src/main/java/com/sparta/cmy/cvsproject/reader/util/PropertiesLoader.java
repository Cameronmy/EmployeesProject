package com.sparta.cmy.cvsproject.reader.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties getProperties(){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("C:\\Users\\Cameron\\IdeaProjects\\FileIO\\src\\main\\resources\\database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}

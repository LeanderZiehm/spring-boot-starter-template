package com.leanderziehm.example_app.utils;

public class Utils {

    public static Integer parseOrDefault(String value, Integer defaultValue) {
        try {
            return value != null ? Integer.valueOf(value) : defaultValue;
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
        
    
}

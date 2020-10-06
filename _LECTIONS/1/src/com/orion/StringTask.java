package com.orion;

public class StringTask {


    public static void main(String[] args) {
        String test = "my String";
        final String replace = test
                .replace("my", "My")
                .replace("my", "My")
                .replace("my", "My")
                .replace("my", "My")
                .replace("my", "My")
                .replace("my", "My")
                .replace("my", "My")
                .replace("my", "My")
                .replace("my", "My");
        System.out.println(replace);
    }
}

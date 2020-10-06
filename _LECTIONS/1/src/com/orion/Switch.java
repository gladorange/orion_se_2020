package com.orion;

public class Switch {


    public static void main(String[] args) {

        String language = "Java";
        String description = switch(language) {
            case "Java" -> "Это джава!";
            case "C++" -> "Это же С++!";
            default -> "Что-то неизвестное";
        };

        System.out.println(description);

    }
}

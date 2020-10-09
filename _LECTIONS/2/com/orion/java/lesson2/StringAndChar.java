package com.orion.java.lesson2;

public class StringAndChar {

    public static void main(String[] args) {
        String textWithNewLIne = "a\\befgh";
        System.out.println(textWithNewLIne);


      /*  char a = 'a';
        System.out.println(a);*/

        for (char c : textWithNewLIne.toCharArray()) {
            System.out.println(c);
        }



    }
}

package com.orion;

import java.util.Random;

public class Loops {




    public static void main(String[] args) {

        String[] names = {"Вася","Петя","Маша"};
        for (String name : names) {
            System.out.println(name);
        }



        int randomEvenNumber;

        do {
            randomEvenNumber = new Random().nextInt(100);
        } while (randomEvenNumber % 2 != 0);



    }

}

package lesson4part2;

import lesson4part2.Fruit;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- 1 ---");

        Apple apple = new Apple();
        Orange orange = new Orange();
        Pineapple pineApple = new Pineapple();

        System.out.println(apple.toString());
        System.out.println(orange.toString());
        System.out.println(pineApple.toString());

        //Создать массив типа Fruit, заполнить его 4 разными случаными фруктами и вывести их на экран


        System.out.println("--- 2 ---");

        Fruit[] fruits = new Fruit[4];

        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = getRandomFruit();

            System.out.println(fruits[i].toString());

        }

        System.out.println("--- 3 ---");



    }



    public static Fruit getRandomFruit(){

        int caseFruit = new Random().nextInt(3);

        if (caseFruit == 0) {return new Apple();}
        if (caseFruit == 1) {return new Orange();}
        if (caseFruit == 2) {return new Pineapple();}

        return null;

    }


}

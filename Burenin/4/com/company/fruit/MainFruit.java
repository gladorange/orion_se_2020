package com.company.fruit;

import java.util.concurrent.ThreadLocalRandom;

public class MainFruit {
    enum Fruits {Apple, Orange, Pineapple}

    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[4];
        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = getRandomFruit();
            System.out.println(fruits[i]);
        }
    }

    public static Fruit getRandomFruit() {
        Fruits type = Fruits.values()[ThreadLocalRandom.current().nextInt(Fruits.values().length)];
        if (type == Fruits.Apple) {
            return new Fruit.Apple();
        }
        else if (type == Fruits.Orange) {
            return new Fruit.Orange();
        }
        else if (type == Fruits.Pineapple) {
            return new Fruit.Pineapple();
        }
        return null;
    }
}

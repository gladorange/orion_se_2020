package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Animal {
    String name;
    String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " " + name;
    }

    public static void main(String[] args) {
        List<Pair<Animal, String>> list = new ArrayList<>();
        list.add(new Pair<>(new Animal("Бобик", "Собака"), "Мясо"));
        list.add(new Pair<>(new Animal("Жуи", "Панда"), "Бамбук"));
        list.add(new Pair<>(new Animal("Кеша", "Попугай"), "Апельсин"));
        feedAnimals(list);
    }

    public static void feedAnimals(List<Pair<Animal, String>> list) {
        for (Pair<Animal, String> pair : list) {
            System.out.println(String.format("Животное %s с радостью сьедает %s", pair.getFirst(), pair.getSecond()));
        }
        Pair<Animal, String> randomPair = list.get(ThreadLocalRandom.current().nextInt(list.size()));
        System.out.println(String.format("Счастливое животное %s получает двойную порцию %s",
                randomPair.getFirst(), randomPair.getSecond()));
    }
}

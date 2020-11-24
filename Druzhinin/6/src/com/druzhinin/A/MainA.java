package com.druzhinin.A;

import com.druzhinin.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainA {

    public static void main(String[] args) {

        List<Pair<Animal, String>> animalCafe = new ArrayList<>();

        animalCafe.add(new Pair<>(new Animal("Бетховен", "Собака"), "Бургер"));
        animalCafe.add(new Pair<>(new Animal("Долли", "Овца"), "Травка"));
        animalCafe.add(new Pair<>(new Animal("Призрак", "Волк"), "Овца"));
        animalCafe.add(new Pair<>(new Animal("Марти", "Зебра"), "Травка"));
        animalCafe.add(new Pair<>(new Animal("Гена", "Крокодил"), "Зебра"));
        animalCafe.add(new Pair<>(new Animal("Тимур", "Козёл"), "Травка"));
        animalCafe.add(new Pair<>(new Animal("Амур", "Тигр"), "Козёл"));

        feedAnimals(animalCafe);
    }

    public static void feedAnimals(List<Pair<Animal,String>> cafe) {
        int luckyNumber = new Random().nextInt(cafe.size());

        for (int i = 0; i < cafe.size(); i++) {
            Animal animal = cafe.get(i).getFirst();
            String dish = cafe.get(i).getSecond();
            if (i == luckyNumber) {
                System.out.printf("Счастливое животное %s получает двойную порцию %s\n", animal.getName(), dish);
                continue;
            }
            System.out.printf("Животное %s с радостью съедает %s\n", animal.getName(), dish);
        }
    }
}

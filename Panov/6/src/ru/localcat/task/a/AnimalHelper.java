package ru.localcat.task.a;

import ru.localcat.corteges.Pair;

import java.util.List;
import java.util.Random;

public class AnimalHelper {
    public static void feedAnimal(List<Pair<Animal, String>> animalList) {

        int luckyAnimalId = new Random().nextInt(animalList.size());
        Animal luckyAnimal = animalList.get(luckyAnimalId).getFirst();

        for (Pair<Animal, String> animalStringPair : animalList) {

            if(luckyAnimal.equals(animalStringPair.getFirst())) {
                System.out.println("Счастливое животное " +animalStringPair.getFirst().getName()+ " получает двойную порцию " + animalStringPair.getSecond());
            }
            else {
                System.out.println("Животное " +animalStringPair.getFirst().getName()+ " с радосьтю съедает " + animalStringPair.getSecond());
            }
        }
    }
}

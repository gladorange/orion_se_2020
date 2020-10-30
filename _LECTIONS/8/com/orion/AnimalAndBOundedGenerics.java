package com.orion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.orion.GenericMethods.Animal;
import com.orion.GenericMethods.Cat;
import com.orion.GenericMethods.Dog;

public class AnimalAndBOundedGenerics {

    public static void main(String[] args) {

        List<Animal> aniamals = new ArrayList<>();

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(0, "Васька"));
        cats.add(new Cat(50, "Мурка"));

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(100, "Шарик"));


        aniamals.addAll(cats);
        aniamals.addAll(dogs);

        printZoo(aniamals);


        printZoo(dogs);
        //printZoo(Arrays.asList("a", "b")); не работает, String не является наследником animal

       // addCat(dogs);


        List<Object> zoo = new ArrayList<>();


        addCat(zoo);
        addDog(zoo);
        zoo.add("Главное здание зоопарка");

        System.out.println(zoo);

    }

    public static void printZoo(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.getName());
        }
    }


    public static void addCat(List<? super Animal> animals) {
        animals.add(new Cat(0, "Машка"));
    }
    public static void addDog(List<? super Animal> animals) {
        animals.add(new Dog(0, "Шарик"));
    }


}

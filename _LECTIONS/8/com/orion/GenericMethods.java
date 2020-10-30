package com.orion;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {





    static abstract class Animal {
        int hungryIndicator;

        public Animal(int hungryIndicator) {
            this.hungryIndicator = hungryIndicator;
        }


        abstract String getName();
    }


    static class Cat extends Animal {
        final String name;

        public Cat(int hungryIndicator, String name) {
            super(hungryIndicator);
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Cat{" +
                    "hungryIndicator=" + hungryIndicator +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    static class Dog extends Animal {
        final String name;

        public Dog(int hungryIndicator, String name) {
            super(hungryIndicator);
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "hungryIndicator=" + hungryIndicator +
                    ", name='" + name + '\'' +
                    '}';
        }
    }




    public static <T extends Animal>  T getMostHungryAnimal(T one, T another) {
        if (one.hungryIndicator > another.hungryIndicator) {
            return one;
        }
        return another;

    }



    public static void main(String[] args) {
        List<Animal> aniamals = new ArrayList<>();

        aniamals.add(new Cat(0, "Васька"));
        aniamals.add(new Cat(50, "Мурка"));
        aniamals.add(new Dog(100, "Шарик"));


        Animal mostHunbgryAnimal = getMostHungryAnimal(aniamals.get(0), aniamals.get(1));

        System.out.println(mostHunbgryAnimal);


        Animal mostHunbgryAnimal2 = getMostHungryAnimal(aniamals.get(1), aniamals.get(2));
        System.out.println(mostHunbgryAnimal2);


    }

}

package com.orion.lesson4.nested;

public class Animal {

    String name;

    public Animal(String name) {
        this.name = name;
    }

    /*class AnimalHouse {
        String address;

        void printOwner() {
            System.out.println(name);
        }

        public AnimalHouse(String address) {
            this.address = address;
        }
    }*/
    static class AnimalHouse {
        final Animal owner;
        final String address;

        void printOwner() {
            System.out.println(owner.name);
        }

        public AnimalHouse(Animal owner, String address) {
            this.owner = owner;
            this.address = address;
        }
    }
}

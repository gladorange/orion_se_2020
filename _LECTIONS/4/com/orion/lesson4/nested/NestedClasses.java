package com.orion.lesson4.nested;

import com.orion.lesson4.nested.Animal.AnimalHouse;

public class NestedClasses {

    public static void main(String[] args) {
        Animal sharik = new Animal("Sharik");
        AnimalHouse house = new AnimalHouse(sharik, "Нижний Ногвород");


        house.printOwner();
    }


}

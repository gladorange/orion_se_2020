package com.orion.lesson4.fabric;

import java.util.Arrays;
import java.util.Random;

public abstract class Fabric {

    class Item {
        String name;

        @Override
        public String toString() {
            return "Item{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    class Car extends Item {

    }


    class Orange extends Item {

    }

    abstract Item getItem();


    public static void main(String[] args) {
        Fabric[] fabrics = {new OrangeFactory(), new CarFactory()};


        Item[] items = new Item[20];

        for (int i = 0; i < 20; i++) {

            items[i] = fabrics[new Random().nextInt(2)].getItem();
        }

        System.out.println(Arrays.toString(items));


    }

}

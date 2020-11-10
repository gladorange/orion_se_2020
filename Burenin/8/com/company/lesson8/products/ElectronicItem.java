package com.company.lesson8.products;

import java.util.concurrent.ThreadLocalRandom;

public abstract class ElectronicItem extends ShopItem {
    double power;

    ElectronicItem(String name) {
        super(name);
        this.power = ThreadLocalRandom.current().nextDouble(1, 100);
    }

    public double getPower() {
        return power;
    }

    public static class TV extends ElectronicItem {

        double volume;

        public TV(String name) {
            super(name);
            this.volume = ThreadLocalRandom.current().nextDouble(1, 50);
        }

        @Override
        public String toString() {
            return "TV{" +
                    "power=" + power +
                    ", volume=" + volume +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
    public static class Refrigerator extends ElectronicItem {

        double capacity;

        public Refrigerator(String name) {
            super(name);
            this.capacity = ThreadLocalRandom.current().nextDouble(1, 30);
        }

        @Override
        public String toString() {
            return "Refrigerator{" +
                    "power=" + power +
                    ", capacity=" + capacity +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}

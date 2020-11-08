package com.company.lesson8.products;

import java.util.concurrent.ThreadLocalRandom;

public abstract class FoodItem extends ShopItem {
    int calorificVal;
    int expirationDate;

    FoodItem(String name) {
        super(name);
        this.calorificVal = ThreadLocalRandom.current().nextInt(1, 100);
        this.expirationDate = ThreadLocalRandom.current().nextInt(1, 10);
    }

    public static class Apple extends FoodItem {
        public enum Color {RED, GREEN, YELLOW}
        Color color;

        public Apple(String name) {
            super(name);
            this.color = Color.values()[ThreadLocalRandom.current().nextInt(Color.values().length)];
        }

        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "calorificVal=" + calorificVal +
                    ", expirationDate=" + expirationDate +
                    ", color=" + color +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static class Bread extends FoodItem {
        int weight;

        public Bread(String name) {
            super(name);
            this.weight = ThreadLocalRandom.current().nextInt(1, 50);
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Bread{" +
                    "calorificVal=" + calorificVal +
                    ", expirationDate=" + expirationDate +
                    ", weight=" + weight +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}

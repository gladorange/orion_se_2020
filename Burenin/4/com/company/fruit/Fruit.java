package com.company.fruit;

import java.util.concurrent.ThreadLocalRandom;

public class Fruit {
    protected int weight;

    Fruit() {
        weight = ThreadLocalRandom.current().nextInt(500);
    }

    enum Color {RED, GREEN, YELLOW}
    static class Apple extends Fruit {
        private Color color;
        Apple() {
            color = Color.values()[ThreadLocalRandom.current().nextInt(Color.values().length)];
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color=" + color +
                    '}';
        }
    }
    static class Orange extends Fruit {
        private int width;

        Orange() {
            width = ThreadLocalRandom.current().nextInt(20);
        }

        @Override
        public String toString() {
            return "Orange{" +
                    "weight=" + weight +
                    ", width=" + width +
                    '}';
        }
    }
    static class Pineapple extends Fruit {
        private int heightTail;

        Pineapple() {
            heightTail = ThreadLocalRandom.current().nextInt(5,20);
        }

        @Override
        public String toString() {
            return "Pineapple{" +
                    "weight=" + weight +
                    ", heightTail=" + heightTail +
                    '}';
        }
    }
}

package com.company.figure;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Figure {
    int x;
    int y;
    public abstract void square();

    public int getQuadrant(int x, int y) {
        if (x > 0 && y > 0)
            return 1;
        else if (x < 0 && y > 0)
            return 2;
        else if (x < 0 && y < 0)
            return 3;
        else if (x > 0 && y < 0)
            return 4;
        else
            return -1;
    }

    static class Circle extends Figure {
        int radius = ThreadLocalRandom.current().nextInt(1, 10);
        @Override
        public void square() {
            System.out.println(String.format("Circle - %s", Math.PI * Math.pow(radius, 2)));
        }
    }

    static class Square extends Figure {
        int length = ThreadLocalRandom.current().nextInt(1, 10);

        @Override
        public void square() {
            System.out.println(String.format("Square - %s", length * 4));
        }
    }

    static class IsoscelesTriangle extends Figure{
        int height = ThreadLocalRandom.current().nextInt(1, 10);
        int base = ThreadLocalRandom.current().nextInt(1, 10);

        @Override
        public void square() {
            System.out.println(String.format("IsoscelesTriangle - %s", height * base / 2));
        }
    }
}

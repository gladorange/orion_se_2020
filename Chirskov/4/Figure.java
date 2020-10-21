import java.lang.Math;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Figure {
    static final int MIN = 1;
    static final int MAX = 10;
    int x;
    int y;
    abstract void square();
    int getQuadrant(int x, int y) {
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
        private int radius = ThreadLocalRandom.current().nextInt(MIN, MAX);
        @Override
        void square() {
            System.out.println("Circle - " + Math.PI * Math.pow(radius, 2));
        }
    }

    static class Square extends Figure {
        private int length = ThreadLocalRandom.current().nextInt(MIN, MAX);
        @Override
        void square() {
            System.out.println("Square - " + Math.pow(length, 2));
        }
    }

    static class IsoscelesTriangle extends Figure {
        private int height = ThreadLocalRandom.current().nextInt(MIN, MAX);
        private int baseSide = ThreadLocalRandom.current().nextInt(MIN, MAX);
        @Override
        void square() {
            System.out.println("IsoscelesTriangle - " + 0.5 * height * baseSide);
        }
    }

    public static void main(String[] args) {
        Figure[] figures = { new Circle(), new Circle(), new Square(), new Square(), new IsoscelesTriangle() };
        for (Figure figure : figures) {
            figure.square();
        }
    }
}
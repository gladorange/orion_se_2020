package ru.localcat.i3;

public abstract class Figure {
    protected int x;
    protected int y;
    protected String figureName;

    public abstract int square();

    public String getFigureName()
    {
        return figureName;
    }

    public int getQuadrant() {
        if (x > 0 && y > 0) {
            return 1;
        }
        if (x > 0 && y < 0) {
            return 3;
        }
        if (x < 0 && y < 0) {
            return 3;
        }
        if (x < 0 && y > 0) {
            return 4;
        }
        return -1;
    }

    protected int validateRange(int value, int min, int max) throws Exception {
        if (value < min || value > max) {
            throw new Exception("Число должно быть в промежутке [" +
                    min +
                    ".." +
                    max
                    + "]");
        }
        return value;
    }

    protected Figure setX(int x) {
        this.x = x;
        return this;
    }

    protected Figure setY(int y) {
        this.y = y;
        return this;
    }
}

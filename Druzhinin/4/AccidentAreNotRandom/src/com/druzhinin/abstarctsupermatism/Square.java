package com.druzhinin.abstarctsupermatism;

public class Square extends Figure {
    public Square(int x, int y, int length) {
        super(x, y);
        this.length = length;
    }

    @Override
    public void square() {
        int square = length * length;
        System.out.printf("Square of %s is %d\n", this.getClass().getName(), square);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private int length;
}

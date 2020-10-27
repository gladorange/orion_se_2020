package com.druzhinin.abstarctsupermatism;

public class Circle extends Figure {
    public Circle(int x, int y, int r) {
        super(x, y);
        this.radius = r;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void square() {
        double square = Math.PI * Math.pow(radius, 2.0);
        System.out.printf("Square of %s is %f\n", this.getClass().getName(), square);
    }

    private int radius;
}

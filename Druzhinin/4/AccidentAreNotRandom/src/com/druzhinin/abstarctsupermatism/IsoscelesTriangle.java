package com.druzhinin.abstarctsupermatism;

public class IsoscelesTriangle extends Figure {
    public int getHeight() {
        return height;
    }

    public int getFooting() {
        return footing;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFooting(int footing) {
        this.footing = footing;
    }

    public IsoscelesTriangle(int x, int y, int height, int footing) {
        super(x, y);
        this.height = height;
        this.footing = height;
    }

    @Override
    public void square() {
        double square = height * footing / 2;
        System.out.printf("Square of %s is %f\n", this.getClass().getName(), square);
    }

    private int height;
    private int footing;
}

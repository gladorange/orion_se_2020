package com.druzhinin.fruitambiguity;

public class Orange extends Fruit {
    private final int MIN_THICKNESS = 0;
    private final int MAX_THICKNESS = 20;

    @Override
    public String toString() {
        return "Orange{" + "weight='" + super.getWeight() + '\'' +
                "crustThickness=" + crustThickness +
                '}';
    }

    public int getCrustThickness() {
        return crustThickness;
    }

    public void setCrustThickness(int thickness) {
        if (thickness >= MIN_THICKNESS & thickness <= MAX_THICKNESS) {
            crustThickness = thickness;
        } else {
            System.out.println("Incorrect thickness, set: " + MIN_THICKNESS);
        }
    }

    private int crustThickness;
}

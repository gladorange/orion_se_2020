package com.druzhinin.fruitambiguity;

public class Pineapple extends Fruit {
    private final int MIN_HEIGHT = 5;
    private final int MAX_HEIGHT = 20;

    public int getHeightOfTail() {
        return heightOfTail;
    }

    public void setHeightOfTail(int height) {
        if (height >= MIN_HEIGHT & height <= MAX_HEIGHT) {
            heightOfTail = height;
        } else {
            System.out.println("Incorrect height, set: " + MIN_HEIGHT);
            heightOfTail = MIN_HEIGHT;
        }
    }

    private int heightOfTail;

    @Override
    public String toString() {
        return "Pineapple{" + "weight='" + super.getWeight() + '\'' +
                "heightOfTail=" + heightOfTail +
                '}';
    }
}

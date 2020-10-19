package ru.localcat.i2;

import java.util.Random;

public class Apple extends FruitImpl {
    private String color;

    public Apple() {

    }

    public Apple(String color) {
        this.color = color;
    }

    @Override
    public void fillWithRandomCharacteristics() {
        super.fillWithRandomCharacteristics();
        this.color = Colors.values()[new Random().nextInt(Colors.values().length - 1)].toString();

    }

    @Override
    public String toString() {
        return "Apple : " +
                "color='" + color + '\'' +
                super.toString();
    }
}

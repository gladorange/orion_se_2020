package ru.localcat.i2;

import java.util.Random;

public class FruitImpl implements Fruit{
    protected int weight;

    protected FruitImpl() {
    }

    public FruitImpl(int weight) {
        this.weight = weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return  " weight=" + weight;
    }

    @Override
    public void fillWithRandomCharacteristics() {
        this.weight = new Random().nextInt(100);
    }
}

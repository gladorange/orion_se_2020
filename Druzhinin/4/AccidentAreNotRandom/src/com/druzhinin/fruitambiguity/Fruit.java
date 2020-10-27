package com.druzhinin.fruitambiguity;

public abstract class Fruit {
    public int getWeight() {
        return weight;
    }

    public void setWeight(int fruitWeight) {
        weight = fruitWeight;
    }

    private int weight;

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }
}


package Fruit;

import java.util.Random;

public abstract class Fruit {
    static final int MAX_FRUIT_WEIGHT = 100;
    protected int fruitWeight;
    private static final Random RANDOM = new Random();

    public Fruit() {
        this.fruitWeight = RANDOM.nextInt(MAX_FRUIT_WEIGHT);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}



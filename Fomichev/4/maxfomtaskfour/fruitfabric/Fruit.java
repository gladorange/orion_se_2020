package maxfomtaskfour.fruitfabric;

import java.util.Random;

public class Fruit {
    public int weight;

    public Fruit() {
        this.weight = new Random().nextInt(1000);;
    }

    @Override
    public String toString() {
        return "Это какой-то фрукт - {" +
                "Вес = " + weight +
                '}';
    }
}

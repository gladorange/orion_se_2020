package maxfomtaskfour.fruitfabric;

import java.util.Random;

public class Pineapple extends Fruit {
    public int height = new Random().nextInt(16) + 5;

    public Pineapple() {
    }

    @Override
    public String toString() {
        return "Это Ананас - {" +
                "Высота хвоста " + height +
                ", Вес = " + weight +
                '}';
    }
}

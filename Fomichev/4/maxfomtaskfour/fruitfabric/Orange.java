package maxfomtaskfour.fruitfabric;

import java.util.Random;

public class Orange extends Fruit {
    public int width;

    public Orange() {
        this.width = new Random().nextInt(20);
    }

    @Override
    public String toString() {
        return "Это Апельсин - {" +
                "Толщина кожуры " + width +
                ", Вес = " + weight +
                '}';
    }
}

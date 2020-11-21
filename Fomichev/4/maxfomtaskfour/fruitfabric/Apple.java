package maxfomtaskfour.fruitfabric;

import java.util.Random;

public class Apple extends Fruit {
    static String[] color = {"Зеленое", "Красное", "Желтое"};

    public Apple() {
    }

    public String getRealColor() {
        int realColor = new Random().nextInt(3);
        return color[realColor];
    }

    @Override
    public String toString() {
        return "Это яблоко - {" +
                "Цвет = " + getRealColor() +
                ", Вес = " + weight +
                '}';
    }
}

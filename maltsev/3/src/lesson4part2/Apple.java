package lesson4part2;

import java.util.Random;

public class Apple extends Fruit {
    public enum Colors {Красное,Зеленое,Желтое};
    String color;

    public Apple() {
        this.color = Colors.values()[new Random().nextInt(Colors.values().length)].toString();
    }

    @Override
    public String toString()
    {
        return this.color + " яблоко";
    }

}

package Fruit;

import java.util.Random;

public class Apple extends Fruit {
    private final String appleColor;

    private static final Random RANDOM = new Random();

    public Apple(){
        appleColor = Colors.values()[RANDOM.nextInt(Colors.values().length-1)].toString();
    }

    @Override
    public String toString() {
        return "Это яблоко с цветом "+appleColor+" с весом "+super.fruitWeight;
    }


}

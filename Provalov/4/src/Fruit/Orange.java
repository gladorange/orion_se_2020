package Fruit;

import java.util.Random;

public class Orange extends Fruit {
    private final int peelThick;

    private static final Random RANDOM = new Random();


    public Orange(){
        final int MAX_PEEL_THICK = 10;
        this.peelThick = RANDOM.nextInt(MAX_PEEL_THICK);
    }

    @Override
    public String toString() {
        return "Это апельсин с толщиной шкуры "+peelThick+" c весом "+super.fruitWeight;
    }
}

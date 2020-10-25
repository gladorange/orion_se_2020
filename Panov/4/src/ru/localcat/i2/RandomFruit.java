package ru.localcat.i2;

import java.util.ArrayList;
import java.util.Random;

public class RandomFruit {
    private static ArrayList<Class<? extends FruitImpl>> fruitClassNames = new ArrayList<>();

    static {
        fruitClassNames.add(Apple.class);
        fruitClassNames.add(Orange.class);
        fruitClassNames.add(Pineapple.class);
    }

    public static FruitImpl getRandomFruitWithoutParams() throws IllegalAccessException, InstantiationException {
        int countClass = fruitClassNames.size();
        return fruitClassNames.get(new Random().nextInt(countClass)).newInstance();
    }

    public static FruitImpl getRandomFruit() throws InstantiationException, IllegalAccessException {
        FruitImpl instance = getRandomFruitWithoutParams();
        instance.fillWithRandomCharacteristics();
        return instance;
    }

}

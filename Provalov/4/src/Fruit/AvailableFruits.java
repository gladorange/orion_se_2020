package Fruit;

import java.util.Random;

public enum AvailableFruits {
    APPLE, ORANGE, PINEAPPLE;

    private static final Random RANDOM = new Random();

    public static AvailableFruits getRandomAvailableFruit(){
        return AvailableFruits.values()[RANDOM.nextInt(AvailableFruits.values().length)];
    }
}

import com.druzhinin.accidentarenotrandom.*;
import com.druzhinin.fruitambiguity.*;

import java.util.Random;

public class Main {

    public static void main(String [] args) {

        // #4.1
        System.out.println("#4.1********************");
        new SequentialRandom();
        new SequentialRandom();
        new SequentialRandom();
        SequentialRandom.resetRandom();
        new SequentialRandom();
        new SequentialRandom();

        // #4.2
        System.out.println("\n#4.2********************");
        final int ARRAY_SIZE = 4;
        Fruit [] fruits = new Fruit[ARRAY_SIZE];

        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = getRandomFruit();
            System.out.println(fruits[i].toString());
        }

    }

    public static Fruit getRandomFruit() {

        final int MAX_RAND = 100;
        final int kindsOfFruit = 3;

        int typeOfFruit = new Random().nextInt(kindsOfFruit);
        Random random = new Random();

        switch (typeOfFruit) {
            case 0:
                COLORS [] arrayColors = COLORS.values();
                COLORS randomColor = arrayColors[random.nextInt(COLORS.values().length)];
                String colorName = randomColor.name();

                Apple randomApple = new Apple();
                randomApple.setWeight(random.nextInt(MAX_RAND));
                randomApple.setColor(colorName);

                return randomApple;
            case 1:
                Orange randomOrange = new Orange();
                randomOrange.setWeight(random.nextInt(MAX_RAND));
                randomOrange.setCrustThickness(random.nextInt(MAX_RAND));

                return randomOrange;
            case 2:
                Pineapple randomPineapple = new Pineapple();
                randomPineapple.setWeight(random.nextInt(MAX_RAND));
                randomPineapple.setHeightOfTail(random.nextInt(MAX_RAND));

                return randomPineapple;
            default:
                return new Apple();
        }
    }
}



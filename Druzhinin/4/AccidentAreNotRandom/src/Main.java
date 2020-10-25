import com.druzhinin.abstarctsupermatism.Circle;
import com.druzhinin.abstarctsupermatism.Figure;
import com.druzhinin.abstarctsupermatism.IsoscelesTriangle;
import com.druzhinin.abstarctsupermatism.Square;
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

        // #4.3
        System.out.println("\n#4.3********************");
        Figure [] figure = new Figure[5];

        figure[0] = new Circle(10, 10, 10);
        figure[1] = new Square(1000, 110, 10);
        figure[2] = new IsoscelesTriangle(100, 600, 10, 10);
        figure[3] = new Circle(1200, 700, 100);
        figure[4] = new Square(20, 20, 100);

        for(int i = 0; i < figure.length; i++) {
            Figure currentFigure = figure[i];
            currentFigure.square();
            System.out.println("Quadrant: " + currentFigure.getQuadrant());
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



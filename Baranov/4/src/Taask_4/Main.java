package Taask_4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static Fruit createFruit(String fruits) {
        return switch (fruits) {
            case "Apple" -> new Apple();
            case "Orange" -> new Orange();
            case "Pineapple" -> new Pineapple();
            default -> throw new IllegalStateException("Unexpected value: " + fruits);
        };
    }

    public static void main(String[] args) {
        // SequentialRandom
        SequentialRandom randomNumber = new SequentialRandom();
        System.out.println(randomNumber);
        SequentialRandom randomNumber2 = new SequentialRandom();
        System.out.println(randomNumber2);
        SequentialRandom randomNumber3 = new SequentialRandom();
        System.out.println(randomNumber3);
        SequentialRandom randomNumber4 = new SequentialRandom();
        System.out.println(randomNumber4);

        SequentialRandom.resetRandom();

        SequentialRandom randomNumber5 = new SequentialRandom();
        System.out.println(randomNumber5);
        SequentialRandom randomNumber6 = new SequentialRandom();
        System.out.println(randomNumber6);
        SequentialRandom randomNumber7 = new SequentialRandom();
        System.out.println(randomNumber7);

        // Fruits
        List<String> fruits = new ArrayList<>();
        fruits.add(Apple.class.getSimpleName());
        fruits.add(Pineapple.class.getSimpleName());
        fruits.add(Orange.class.getSimpleName());
        for (int i = 0; i <= 4; i++) {
            int random = ThreadLocalRandom.current().nextInt(fruits.size());
            System.out.println(Main.createFruit(fruits.get(random)));
        }

        // Figure
        Figure[] figures = {
                new IsoscelesTriangle(5, 7),
                new Circle(9),
                new Square(4)
        };
        for (Figure figure: figures) {
            System.out.println(figure.square());
        }
    }
}

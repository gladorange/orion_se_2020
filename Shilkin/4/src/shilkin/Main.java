package shilkin;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        SequentialRandom sq1 = new SequentialRandom();
        System.out.println("Значение переменной " + SequentialRandom.getMyInt());
        SequentialRandom sq2 = new SequentialRandom();
        System.out.println("Значение переменной " + SequentialRandom.getMyInt());
        SequentialRandom sq3 = new SequentialRandom();
        System.out.println("Значение переменной " + SequentialRandom.getMyInt());
        SequentialRandom.resetRandom();
        SequentialRandom sq4 = new SequentialRandom();
        System.out.println("Значение переменной " + SequentialRandom.getMyInt());
        SequentialRandom sq5 = new SequentialRandom();
        System.out.println("Значение переменной " + SequentialRandom.getMyInt());
        System.out.println();

        Fruit[] fruits = new Fruit[4];
        for (int i = 0; i < fruits.length; i++){
            fruits[i] = getRandomFruit();
            System.out.println(fruits[i].toString());
        }
        System.out.println();

        Figure[] figures = new Figure[4];
        for (int i = 0; i < figures.length; i++){
            figures[i] = getRandomFigure();
            System.out.println(figures[i].toString());
        }
    }

    static Figure getRandomFigure(){
        Random randomFigure = new Random();
        int figure = randomFigure.nextInt(3);

        switch (figure) {
            case 0 -> {
                Random randomCircleX = new Random();
                Random randomCircleY = new Random();
                Random randomRadius = new Random();
                return new Circle(randomCircleX.nextInt(100), randomCircleY.nextInt(100), randomRange(1,10, randomRadius));
            }
            case 1 -> {
                Random randomSquareX = new Random();
                Random randomSquareY = new Random();
                Random randomSideLength = new Random();
                return new Square(randomSquareX.nextInt(100), randomSquareY.nextInt(100), randomRange(1,10, randomSideLength));
            }
            case 2 -> {
                Random randomIsoscelesTriangleX = new Random();
                Random randomIsoscelesTriangleY = new Random();
                Random randomHeight = new Random();
                Random randomBase = new Random();
                return new IsoscelesTriangle(randomIsoscelesTriangleX.nextInt(100), randomIsoscelesTriangleY.nextInt(100), randomRange(1,10, randomHeight), randomRange(1,10, randomBase));
            }
            default ->{
                return new Figure(0,0);
            }
        }
    }

    static Fruit getRandomFruit(){
        Random randomFruit = new Random();
        int fruit = randomFruit.nextInt(3);

        switch (fruit) {
            case 0 -> {
                final String[] colors = {"Красный", "Зеленый", "Желтый"};
                Random randomColor = new Random();
                Random randomAppleWeight = new Random();
                return new Apple(randomAppleWeight.nextInt(10), colors[randomColor.nextInt(3)]);
            }
            case 1 -> {
                Random randomPeelThickness = new Random();
                Random randomOrangeWeight = new Random();
                return new Orange(randomOrangeWeight.nextInt(10), randomPeelThickness.nextInt(20));
            }
            case 2 -> {
                Random randomTailHeight = new Random();
                Random randomPineappleWeight = new Random();
                return new Pineapple(randomPineappleWeight.nextInt(10),randomRange(5, 20, randomTailHeight));
            }
            default ->{
                return new Fruit(20);
            }
        }
    }

    static int randomRange(int min, int max, Random random){
        int diff = max - min;
        return random.nextInt(diff) + 1 + min;
    }
}

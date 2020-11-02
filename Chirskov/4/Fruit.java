import java.util.concurrent.ThreadLocalRandom;

public abstract class Fruit {
    protected int weight;
    static final int MAX_WEIGHT = 999;
    Fruit() {
        setWeight(ThreadLocalRandom.current().nextInt(1, MAX_WEIGHT));
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }

    enum Color { RED, GREEN, YELLOW }
    public static class Apple extends Fruit {
        private Color color;

        public void setColor(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        static Fruit getRandomFruit() {
            Apple apple = new Apple();
            apple.setColor(Color.values()[ThreadLocalRandom.current().nextInt(0, Color.values().length)]);
            return apple;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color=" + color +
                    '}';
        }
    }

    public static class Orange extends Fruit {
        static final int MIN_PEEL_THICKNESS = 0;
        static final int MAX_PEEL_THICKNESS = 20;
        private int peelThickness;

        public void setPeelThickness(int peelThickness) {
            this.peelThickness = peelThickness;
        }

        public int getPeelThickness() {
            return peelThickness;
        }

        static Fruit getRandomFruit() {
            Orange orange = new Orange();
            orange.setPeelThickness(ThreadLocalRandom.current().nextInt(MIN_PEEL_THICKNESS, MAX_PEEL_THICKNESS));
            return orange;
        }

        @Override
        public String toString() {
            return "Orange{" +
                    "weight=" + weight +
                    ", peelThickness=" + peelThickness +
                    '}';
        }
    }

    public static class Pineapple extends Fruit {
        static final int MIN_TAIL_HEIGHT = 5;
        static final int MAX_TAIL_HEIGHT = 20;
        private int tailHeight;

        public void setTailHeight(int tailHeight) {
            this.tailHeight = tailHeight;
        }

        public int getTailHeight() {
            return tailHeight;
        }

        static Fruit getRandomFruit() {
            Pineapple pineapple = new Pineapple();
            pineapple.setTailHeight(ThreadLocalRandom.current().nextInt(MIN_TAIL_HEIGHT, MAX_TAIL_HEIGHT));
            return pineapple;
        }

        @Override
        public String toString() {
            return "Pineapple{" +
                    "weight=" + weight +
                    ", tailHeight=" + tailHeight +
                    '}';
        }
    }
    enum AvailableFruits { Apple, Orange, Pineapple }
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[4];
        initRandomFruits(fruits);
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }

    static void initRandomFruits(Fruit[] fruits) {
        for (int i = 0; i < fruits.length; ++i) {
            int fruitNumber = ThreadLocalRandom.current().nextInt(0, AvailableFruits.values().length);
            AvailableFruits fruit = AvailableFruits.values()[fruitNumber];
            switch (fruit) {
                case Apple:
                    fruits[i] = Apple.getRandomFruit();
                    break;
                case Orange:
                    fruits[i] = Orange.getRandomFruit();
                    break;
                case Pineapple:
                    fruits[i] = Pineapple.getRandomFruit();
                    break;
                default:
                    System.out.println("Нет такого фрукта!");
                    break;
            }
        }
    }
}

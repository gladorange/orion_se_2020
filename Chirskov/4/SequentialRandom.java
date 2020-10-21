import java.util.concurrent.ThreadLocalRandom;

public class SequentialRandom {
    SequentialRandom(){
        number = number == 0 ? ThreadLocalRandom.current().nextInt() : ++number;
    }
    private static int number;
    static int getNumber() { return number; }
    static void resetRandom() { number = 0; }

    public static void main(String[] args) {
        new SequentialRandom();
        print();
        new SequentialRandom();
        print();
        new SequentialRandom();
        print();
        SequentialRandom.resetRandom();
        new SequentialRandom();
        print();
        new SequentialRandom();
        print();
    }

    public static void print() {
        System.out.println("Содержит " + getNumber());
    }
}

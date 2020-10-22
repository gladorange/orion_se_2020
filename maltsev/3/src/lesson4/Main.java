package lesson4;

import lesson4.SequentialRandom;

public class Main {
    public static void main(String[] args) {

        new SequentialRandom();
        new SequentialRandom();
        new SequentialRandom();
        System.out.println("Сброс");
        SequentialRandom.resetRandom();
        new SequentialRandom();
        new SequentialRandom();
        new SequentialRandom();

    }
}

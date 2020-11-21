package maxfomtaskfour.sequentialrandom;

import java.util.Random;

public class SequentialRandom {

    private static int sequential;
    private static boolean step = true;

    public int getSequential() {
        return sequential;
    }

    public SequentialRandom() {
        if (step) {
            sequential = new Random().nextInt(50);
            step = false;
        }
        else {
            sequential++;
        }
    }

    static void resetRandom() {
        step = true;
        System.out.println("== Random update ==");
    }

    public static void main(String[] args) {
        SequentialRandom random1 = new SequentialRandom();
        System.out.println(random1.getSequential());
        SequentialRandom random2 = new SequentialRandom();
        System.out.println(random2.getSequential());
        SequentialRandom random3 = new SequentialRandom();
        System.out.println(random3.getSequential());
        SequentialRandom.resetRandom();
        SequentialRandom random4 = new SequentialRandom();
        System.out.println(random4.getSequential());
        SequentialRandom random5 = new SequentialRandom();
        System.out.println(random5.getSequential());
        SequentialRandom random6 = new SequentialRandom();
        System.out.println(random6.getSequential());

    }
}

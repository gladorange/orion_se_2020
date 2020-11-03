package Taask_4;

import java.util.concurrent.ThreadLocalRandom;

public class Pineapple extends Fruit {
    final int MIN_TAILLIGHT = 5;
    final int MAX_TAILLIGHT = 20;
    public int tailHeight;

    public Pineapple() {
        super();
        this.tailHeight = ThreadLocalRandom.current().nextInt(MIN_TAILLIGHT, MAX_TAILLIGHT);
    }

    public Pineapple(int weight, int tailHeight) {
        super(weight);
        this.tailHeight = tailHeight;
    }

    @Override
    public String toString() {
        return "Pineapple{" +
                "weight='" + weight + '\'' +
                "tailHeight='" + tailHeight + '\'' +
                '}';
    }
}

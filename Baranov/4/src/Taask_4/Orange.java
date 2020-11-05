package Taask_4;

import java.util.concurrent.ThreadLocalRandom;

public class Orange extends Fruit {
    final int MIN_DEPTH = 0;
    final int MAX_DEPTH = 20;
    public int skinDepth;

    public Orange() {
        super();
        this.skinDepth = ThreadLocalRandom.current().nextInt(MIN_DEPTH, MAX_DEPTH);
    }

    public Orange(int weight, int skinDepth) {
        super(weight);
        this.skinDepth = skinDepth;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight='" + weight + '\'' +
                "skinDepth='" + skinDepth + '\'' +
                '}';
    }
}

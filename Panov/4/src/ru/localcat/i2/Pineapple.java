package ru.localcat.i2;

import java.util.concurrent.ThreadLocalRandom;

public class Pineapple extends FruitImpl {
    private static final int TAIL_HEIGHT_MIN = 5;
    private static final int TAIL_HEIGHT_MAX = 20;

    private int tailHeight = TAIL_HEIGHT_MIN;

    public Pineapple() {

    }

    public Pineapple(int tailHeight) {
        try {
            this.tailHeight = validateTailHeight(tailHeight);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int validateTailHeight(int tailHeight) throws Exception {
        if (tailHeight < TAIL_HEIGHT_MIN || tailHeight > TAIL_HEIGHT_MAX) {
            throw new Exception("Высота хвоста ананаса должна быть в диапазоне [" +
                    TAIL_HEIGHT_MIN +
                    ".." +
                    TAIL_HEIGHT_MAX
                    + "]");
        }
        return tailHeight;
    }

    @Override
    public void fillWithRandomCharacteristics() {
        super.fillWithRandomCharacteristics();
        try {
            this.tailHeight = validateTailHeight(ThreadLocalRandom.current().nextInt(TAIL_HEIGHT_MIN, TAIL_HEIGHT_MAX));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Pineapple : " +
                " tailHeight=" + tailHeight +
                super.toString();
    }
}

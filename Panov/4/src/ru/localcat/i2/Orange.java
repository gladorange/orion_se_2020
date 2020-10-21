package ru.localcat.i2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Orange extends FruitImpl {
    private static final int PEEL_THICKNESS_MIN = 0;
    private static final int PEEL_THICKNESS_MAX = 20;

    private int peelThickness = PEEL_THICKNESS_MIN;

    public Orange() {

    }

    public Orange(int peelThickness) {
        try {
            this.peelThickness = validatePeelThickness(peelThickness);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int validatePeelThickness(int peelThickness) throws Exception {
        if (peelThickness < PEEL_THICKNESS_MIN || peelThickness > PEEL_THICKNESS_MAX) {
            throw new Exception("Толщина корки апельсина должна быть в диапазоне [" +
                    PEEL_THICKNESS_MIN +
                    ".." +
                    PEEL_THICKNESS_MAX
                    + "]");
        }
        return peelThickness;
    }

    @Override
    public void fillWithRandomCharacteristics() {
        super.fillWithRandomCharacteristics();
        try {
            this.peelThickness = validatePeelThickness(ThreadLocalRandom.current().nextInt(PEEL_THICKNESS_MIN, PEEL_THICKNESS_MAX));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Orange : " +
                " peelThickness=" + peelThickness +
                super.toString();
    }
}

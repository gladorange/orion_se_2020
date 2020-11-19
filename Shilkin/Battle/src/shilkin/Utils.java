package shilkin;

import java.util.Random;

public class Utils {

    public static int getRandomRange(int min, int max) {
        Random random = new Random();
        int diff = max - min;
        return random.nextInt(diff) + 1 + min;
    }
}

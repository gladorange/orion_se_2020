package shilkin;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Utils {

    public static int getRandomRange(int min, int max) {
        Random random = new Random();
        int diff = max - min;
        return random.nextInt(diff) + 1 + min;
    }
    public static int getRandomElement(List<Character> list){
        Random random = new Random();
        return random.nextInt(list.size());
    }
}

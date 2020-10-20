package attractionofopposites;

import java.util.Random;

public class AttractionOfOpposites {
    private static final int ARRAY_SIZE = 10;
    private int [] arrayOfIntegers = new int[ARRAY_SIZE];

    public void fillArray() {
        for(int i = 0; i < arrayOfIntegers.length; i++) {
            Random random = new Random();
            
            arrayOfIntegers[i] = random.nextInt();
        }
    }

    public void printOfArray() {
        for (int i : arrayOfIntegers) {
            System.out.println(i);
        }
    }

    void checkOpposites() {
        for (int i = 0; i < arrayOfIntegers.length - 1; ++i) {
            int current = arrayOfIntegers[i];
            int next = arrayOfIntegers[i + 1];

            if ((current > 0 & next < 0) | (current < 0 & next > 0)) {
                System.out.printf("Числа с противоположными знаками обнаружены: %d %d\n", current, next);
            }
        }
    }

}

package number;

import java.util.Random;

public class OppositesNumbers {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] > 0 && arr[i + 1] < 0) || (arr[i] < 0 && arr[i + 1] > 0)) {
                System.out.println(
                        String.format("Числа с противоположными знаками обнаружены: %s %s", arr[i], arr[i + 1])
                );
            }
        }

    }
}

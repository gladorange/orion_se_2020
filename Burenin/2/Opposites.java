import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Opposites {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            if (isOpposites(arr[i], arr[i + 1])) {
                System.out.println(String.format("Числа с противоположными знаками обнаружены: %s %s", arr[i], arr[i + 1]));
            }
        }
    }

    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isOpposites(int firstNum, int secondNum) {
        if (firstNum == 0 || secondNum == 0)
            return false;

        return isPositive(firstNum) ^ isPositive(secondNum);
    }
}

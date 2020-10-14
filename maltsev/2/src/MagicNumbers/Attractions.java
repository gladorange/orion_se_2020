package MagicNumbers;

import java.util.Arrays;
import java.util.Random;

import static MagicNumbers.magicnumbers.getRandomInRange;

public class Attractions {

    public static void main(String[] args) {

        int arr[] = new int[10];

        for (int j = 0; j < arr.length; j++) {
            arr[j] = rnd(-2147483648, 2147483647);
        }

        // вывожу массив
        System.out.println("Массив " + Arrays.toString(arr));

        for (int i = 0; i < arr.length-1; i++) {
            if ((long)arr[i]*(long)arr[i+1] < 0)
            {
                System.out.println(String.format("Числа с противоположными знаками обнаружены: %d %d", arr[i], arr[i+1]));
            }

        }
    }

    static int rnd(int min, int max)
    {
        // random по всему диапазону Int от -2147483648 до 2147483647
        return (int) ((Math.random() * ((long)max-(long)min)) + min);
    }
}

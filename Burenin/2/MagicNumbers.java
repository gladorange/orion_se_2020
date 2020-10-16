import java.util.Random;

public class MagicNumbers {

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(201) - 100;
            if (isMagicNumber(arr[i])) {
                System.out.println(String.format("Число %s - магическое!", arr[i]));
            }
        }
    }

    public static boolean isMagicNumber(int number) {
        int div = number / 10;
        int remainder = number % 10;

        if (Math.abs(div) > 0 && Math.abs(div) < 10 && div == remainder) {
            return true;
        }
        return false;
    }
}

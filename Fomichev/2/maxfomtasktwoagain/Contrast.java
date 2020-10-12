package maxfomtasktwoagain;
import java.util.Random;

public class Contrast {
    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt();
            System.out.println(nums[i]);
        }
        for (int i = 1; i < nums.length; i++) {
            compareNumbers(nums[i-1], nums[i]);
        }
    }

    static void compareNumbers(int number, int numberTwo) {
        if ((number > 0) && (numberTwo < 0))
            System.out.println("Числа с противоположными знаками обнаружены: " + number + " " + numberTwo);
        else if ((number < 0) && (numberTwo > 0))
            System.out.println("Числа с противоположными знаками обнаружены: " + number + " " + numberTwo);

    }

}

package maxfomtasktwo;
import java.util.Random;


public class Magic {

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(201) - 100;
        }
        for (int i = 0; i < 100; i++) {
            isMagicNumber(nums[i]);
        }

    }

     static boolean isMagicNumber(int number) {
            if ((number / 10) == (number % 10) && (number != 0)) {
                System.out.println("Число " + number + " - магическое!");
                return true;
            }
            else
                return false;
    }

}

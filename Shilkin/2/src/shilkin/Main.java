package shilkin;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] firstArray = new int[100];
        int[] secondArray = new int[10];

        final int min = -100;
        final int max = 100;
        final int diff = max - min;

        for (int i = 0; i < firstArray.length; i++){
            Random random = new Random();
            firstArray[i] = random.nextInt(diff + 1) + min;
        }

        for (int i = 0; i < firstArray.length; i++){
            if (NumberUtils.isMagicNumber(firstArray[i])){
                System.out.println("Число " + firstArray[i] + " - магическое!");
            }
        }

        System.out.println();

        for (int i = 0; i < secondArray.length; i++){
            Random random = new Random();
            System.out.println(secondArray[i] = random.nextInt());
        }

        System.out.println();

        for (int i = 0; i < secondArray.length-1; i++){
            if (NumberUtils.isOppositeNumbers(secondArray[i], secondArray[i+1])){
                System.out.println("Числа с противоположными знаками обнаружены: " + secondArray[i] + " " + secondArray[i+1]);
            }
        }

    }
}



package shilkin;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] firstArray = new int[100];

        int min = -100;
        int max = 100;

        for (int i = 0; i < 100; i++){

            int diff = max - min;
            Random random = new Random();

            firstArray[i] = random.nextInt(diff + 1) + min;

        }

        for (int i = 0; i < 100; i++){

            if (Help.isMagicNumber(firstArray[i])){

                System.out.println("Число " + firstArray[i] + " - магическое!");

            }

        }

        System.out.println();

        int[] secondArray = new int[10];

        for (int i = 0; i < 10; i++){

            Random random = new Random();

            System.out.println(secondArray[i] = random.nextInt());

        }

        System.out.println();

        for (int i = 0; i < 9; i++){

            if (Help.isOppositeNumbers(secondArray[i], secondArray[i+1])){

                System.out.println("Числа с противоположными знаками обнаружены: " + secondArray[i] + " " + secondArray[i+1]);

            }

        }

    }
}



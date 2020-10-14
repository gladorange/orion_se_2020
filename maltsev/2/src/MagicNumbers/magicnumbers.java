package MagicNumbers;

import java.util.Random;

import static java.lang.Math.abs;

public class magicnumbers {

    public static void main(String[] args) {

        int arr[] = new int[100];

            // делаем массив случайных чисел в ренже -100 до 100
            for (int j = 0; j < arr.length; j++) {
                arr[j] = getRandomInRange(-100,100);
        }

            // проверяю цифры на магичество
        for ( Integer i : arr ) {
            if (isMagicNumber(i))
            {
                System.out.println("Чисто "+i.toString()+" - магическое!");
            }
        }
    }

    static int getRandomInRange(int a1, int a2) {
        Random r = new Random();
        return r.nextInt((Math.max(a1, a2) - Math.min(a1, a2)) + 1) + Math.min(a1, a2);
    }

    public static boolean isMagicNumber(Integer number){

        // магичность числа определяю следующим образом:
        // 1.модуль числа перевожу в строку
        // 2.удаляю все символы из строки, похожие на первый символ
        // 3.число магическое <-> если длина строки = 0

        Integer positive = Math.abs(number);

        if (positive.toString().replaceAll(positive.toString().substring(0,1),"").length() == 0){
            return true;
        }else{
            return false;
        }

    }

}
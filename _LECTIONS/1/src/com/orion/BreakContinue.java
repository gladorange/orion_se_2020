package com.orion;

public class BreakContinue {


    public static void main(String[] args) {
        // проверим, есть ли отрицательные цены
        int[] prices = {1, 2, 3, -5, 4, 5, 1999, 222, 444, 222};


        boolean hasNegative = false;
        for (int price : prices) {
            if (price < 0) {
                hasNegative = true;
                break;
            }
        }

        if (hasNegative) {
            System.out.println("Обнаружен товар с отрицательной ценой");
        }


        // посчитаем длину всех слов, в которых нет буквы а.
        String[] words = {"Яблоко", "Апельсин", "Ананас", "Гранат", "Киви"};
        int sum = 0;
        for (String word : words) {
            if (word.toLowerCase().contains("а")) {
                continue;
            }

            sum += word.length();
        }

        System.out.println("длина всех слов без буквы А=" + sum);


    }
}

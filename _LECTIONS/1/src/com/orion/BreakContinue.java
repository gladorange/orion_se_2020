package com.orion;

public class BreakContinue {






    public static void main(String[] args) {
        // проверим, есть ли отрицательные цены





        int[][] prices = {
                {1, 2, 3, 5, 4, 5, 1999, 222, 444, 222},
                {1, 2, 3, -5, 4, 5, 1999, -222, -444, -222},
                {1, 2, 3, -5, 4, 5, 1999, 222, 444, 222}

        };




        boolean hasNegative = false;

        int countOfShoptWithNegativePrice = 0;

        outer_loop:
        for (int[] pricesInSomeShop : prices) {

            for (int price : pricesInSomeShop) {
                if (price < 0) {
                    countOfShoptWithNegativePrice++;
                    continue outer_loop;
                }
            }

        }



        if (countOfShoptWithNegativePrice > 0) {
            System.out.println("Обнаружен товар с отрицательной ценой в  нескольких магазинах:" + countOfShoptWithNegativePrice );
        }


       /* // посчитаем длину всех слов, в которых нет буквы а.
        String[] words = {"Яблоко", "Апельсин", "Ананас", "Гранат", "Киви"};
        int sum = 0;
        for (String word : words) {
            if (word.toLowerCase().contains("а")) {
                continue;
            }

            sum += word.length();
        }

        System.out.println("длина всех слов без буквы А=" + sum);*/


    }
}

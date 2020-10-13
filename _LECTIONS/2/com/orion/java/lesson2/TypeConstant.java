package com.orion.java.lesson2;

public class TypeConstant {

    public static void main(String[] args) {

        int[] nums = {1,-1,3,-1,5,-1,2,-3,3};

        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < nums.length; j++) {
                compareNumbers(nums[i], nums[j]);
                i++;
            }
        }

    }

    static void compareNumbers(int number, int numberTwo) {
        if ((number > 0) && (numberTwo < 0))
            System.out.println("Числа с противоположными знаками обнаружены: " + number + " " + numberTwo);
        else if ((number < 0) && (numberTwo > 0))
            System.out.println("Числа с противоположными знаками обнаружены: " + number + " " + numberTwo);

    }
}

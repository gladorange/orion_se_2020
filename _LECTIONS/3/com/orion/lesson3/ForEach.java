package com.orion.lesson3;

import java.util.Arrays;

public class ForEach {

    static int[] array = {1, 2, 3};


    public static void main(String[] args) {
        for (int i : array) {
            i = 42;
        }


        System.out.println(Arrays.toString(array));

    }



}

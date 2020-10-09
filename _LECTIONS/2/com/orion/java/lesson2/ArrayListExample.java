package com.orion.java.lesson2;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(1);
        list.add(42);
        list.add(42);
        list.add(42);
        list.add(42);
        list.add(42);
        list.add(42);
        System.out.println("Длина списка " + list.size());

        Integer[] array = new Integer[1];
        array[0] = 42;
        array[1] = 42;
        array[2] = 42;
        System.out.println("Длина массива " + array.length);




        Integer[] arrayPrim = new Integer[1];
        int[] arrayObj = new int[10];
        System.out.println("");


        int a = 2;
        Integer b = a; // упаковка, boxing
        int c = b; // распаковка, unboxing
        //Integer b = new Integer(a);


    }
}

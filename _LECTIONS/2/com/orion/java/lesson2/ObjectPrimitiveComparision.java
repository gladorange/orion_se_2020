package com.orion.java.lesson2;

import javax.management.InstanceNotFoundException;

public class ObjectPrimitiveComparision {


    public static void main(String[] args) {


        final long start = System.currentTimeMillis();
        int[] arrayPrimitive = new int[1_000_000];
        for (int i : arrayPrimitive) {
            arrayPrimitive[i] = i + 1;
        }

        System.out.println(System.currentTimeMillis() - start);


        final long startObject = System.currentTimeMillis();
        Integer[] arrayObject = new Integer[1_000_000];

        for (int i = 0; i < arrayObject.length; i++) {
            arrayObject[i] = i + 1;
        }


        System.out.println(System.currentTimeMillis() - startObject);







    }
}

package com.orion.lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayToCollection {

    public static void main(String[] args) {
        String[] names = {"Vasya","Petya","Masha"};

        final List<String> strings = new ArrayList<>(Arrays.asList(names));

        System.out.println(strings);


        final Iterator<String> iterator = strings.iterator();



        while (iterator.hasNext()) {
            final String next = iterator.next();
            System.out.println("Имя :" + next);

            if (next.equals("Vasya")) {
                //strings.remove("Vasya");
                iterator.remove();
            }
        }

        for (String string : strings) {
            System.out.println("имя через for-each:" + string);
            /*if (string.equals("Vasya")) {
                strings.remove("Vasya");
            }*/
        }


    }
}

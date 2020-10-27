package com.orion.lesson7;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapExample {


    public static void main(String[] args) {


        //Map<String, String> nameToLastname = new HashMap<>(); без порядка
        //Map<String, String> nameToLastname = new LinkedHashMap<>(); // порядока вставки
        Map<String, String> nameToLastname = new TreeMap<>(); // Comparable/Comparator

        nameToLastname.put("Vasya", "Pupkin");
        nameToLastname.put("Petya", "Ivanov");
        nameToLastname.put("1", "2");
        nameToLastname.put("3", "4");
        nameToLastname.put("5", "6");
        nameToLastname.put("9", "10");
        nameToLastname.put("7", "8");


        System.out.println(nameToLastname);


        final String vasya = nameToLastname.get("Vasya");
        System.out.println("Фамилия Васи");
        System.out.println(vasya);


        int i = 1;
        for (Entry<String, String> stringStringEntry : nameToLastname.entrySet()) {
            System.out.println("Пара №" + i++ );
            System.out.println(stringStringEntry);
            stringStringEntry.setValue("changed");
        }


        System.out.println(nameToLastname);
        nameToLastname.put("Petya", "Снова Иванов");
        System.out.println(nameToLastname);



    }
}

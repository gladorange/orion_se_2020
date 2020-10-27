package com.orion.lesson7;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {


    public static void main(String[] args) {
        Queue<String> strings = new LinkedList<>();
       // strings.remove(); не работает, очередь пустая
        final String poll = strings.poll();// вернет null
        System.out.println(poll);
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");


        final String remove = strings.remove();
        System.out.println(remove);
    }
}

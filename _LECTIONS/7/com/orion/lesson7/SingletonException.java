package com.orion.lesson7;

import java.util.Collection;
import java.util.Collections;

public class SingletonException {

    public static void main(String[] args) {


        Collection<String> sing = Collections.singleton("A");
        sing.add("B");


        System.out.println("Конец");
    }
}

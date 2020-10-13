package com.orion.lesson3;

public class SystemVariables {

    public static void main(String[] args) {


        final String variableName = System.getProperty("variableName");
        System.out.println(variableName);

        final Integer integer = Integer.getInteger("42");
        System.out.println(integer);

    }
}

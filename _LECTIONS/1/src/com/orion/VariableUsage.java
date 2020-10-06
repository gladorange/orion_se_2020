package com.orion;

public class VariableUsage {

    public static void main(String[] args) {


        int one = 2;
        int another = 3;
        int sum = one + another;
        System.out.println(sum);


        String str = "Привет";
        String anotherStr = str;// копирование ссылки в переменную another

        int anotherStrLength = anotherStr.length(); // копирование значения, возвращенного методом length() в переменную  anotherStrLength


    }
}

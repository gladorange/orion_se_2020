package com.orion.lesson5;

public class StringBuilderExample {


    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";


        System.out.println(a + b + c + d);


        StringBuilder sb = new StringBuilder(a);
        sb.append(b);
        sb.append(c);
        sb.append(d);

        System.out.println(sb.toString());
    }
}

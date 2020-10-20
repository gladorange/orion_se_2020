package com.orion.lesson5;

public class NPEExample {


    public static void main(String[] args) {


        int a = 2;
        int b = 2;


        Person p = getPerson();
        try {
            //System.out.println(p.name);


            System.out.println(42 / 0);
        } catch (NullPointerException | ArithmeticException e) {
            System.out.println("Случилось исключение " + e.getMessage()+ " на строчке " + e.getStackTrace()[0].getLineNumber());
        }
        System.out.println(a + b);

    }

    private static Person getPerson() {

        return null;
    }
}

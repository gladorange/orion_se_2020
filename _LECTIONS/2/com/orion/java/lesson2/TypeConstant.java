package com.orion.java.lesson2;

public class TypeConstant {


    public static void main(String[] args) {
        boolean tr = true;
        boolean fl = false;


        Boolean b = null;

        if (b != null && b) {
            System.out.println("true");
        }



        Long L = 42L;
        Double d = 1.;
        Double d2 = .5;

        Float f = .0f;
        Float f2 = 2.f;


        long lPrim = 42_000_000_00000000L;
        int prim = (int)lPrim;
        System.out.println(prim);


    }
}

package com.orion.java.lesson2;

import java.math.BigInteger;

public class BigDecimal {


    public static void main(String[] args) {
        BigInteger a = BigInteger.valueOf(24L);
        BigInteger b = BigInteger.valueOf(384L);

        final BigInteger add = a.add(b);

        System.out.println(add);
    }

}

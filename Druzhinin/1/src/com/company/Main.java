package com.company;

public class Main {

    public static void main(String[] args) {

        Integer int1 = Integer.valueOf(args[0]);
        Integer int2 = Integer.valueOf(args[1]);

        if( int1 > int2 )
        {
            System.out.printf( "Число %s больше числа %s\n", int1.toString(), int2.toString());
        }
        else
        {
            System.out.printf( "Число %s меньше числа %s\n", int1.toString(), int2.toString() );
        }

    }
}

package com.orion;

public class Lesson8 {






    public static void main(String[] args) {


        String nonNullStr = getNonNull(null, "ABC");
        System.out.println(nonNullStr);


        Integer nonNullInt = getNonNull(null, 42);
        System.out.println(nonNullInt);


        //final String abc = getNonNull("ABC", 42);


        final String abc1 = "ABC";
        final Integer another = 42;
        final Object abc = getNonNullNongeneric(abc1, another);

    }



    public static <T> T getNonNull(T one, T another) {
        if (one != null) {
            return one;
        }

        return another;
    }

    public static Object getNonNullNongeneric(Object one, Object another) {
        if (one != null) {
            return one;
        }

        return another;
    }

}

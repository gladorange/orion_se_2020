package com.orion;

import java.lang.reflect.Field;

public class ChangeFinalField {


    static class ClassWithFinalField {
        final String finalField;

        ClassWithFinalField(String finalField) {
            this.finalField = finalField;
        }
    }

    public static void main(String[] args) throws Exception {


        ClassWithFinalField i = new ClassWithFinalField("finalValue");

        final Field finalField = i.getClass().getDeclaredField("finalField");
        finalField.setAccessible(true);
        finalField.set(i, "anotherValue");


        System.out.println(i.finalField);

    }
}

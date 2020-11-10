package com.orion.lesson11;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodReferences2 {


    public static void main(String[] args) {
        String text = "A B C D C B D C B D A C B C S";

        Map<Character, BigInteger> characterToCount = new HashMap<>();
        for (char character : text.toCharArray()) {
            characterToCount.merge(character, BigInteger.ONE, BigInteger::add);
            characterToCount.merge(character, BigInteger.ONE, (bigInteger, val) -> bigInteger.add(val));
        }


        System.out.println(characterToCount);


    }


    static class  Person {
        String name;
        Integer age;

        void setNameAndAge(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}

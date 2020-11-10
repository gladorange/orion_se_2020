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


        List<Triple> personsAndNames = new ArrayList<>();


        personsAndNames.add(new Triple(new Person(), "Вася", 18));
        personsAndNames.add(new Triple(new Person(), "Петя", 23));
        personsAndNames.add(new Triple(new Person(), "Маша", 27));


       // personsAndNames.forEach();




    }



    static class Triple {
        final Person person;
        final String nameToSet;
        final Integer ageToSet;

        Triple(Person person, String nameToSet, Integer ageToSet) {
            this.person = person;
            this.nameToSet = nameToSet;
            this.ageToSet = ageToSet;
        }
    }


    interface ElementListHandler {
        void handleTriple(Triple triple);
    }


    interface TripleHandler {
        void handle(Person person, String name, Integer age);
    }

    static class  Person {
        String name;
        Integer age;

        void setNameAndAge(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

    }

}

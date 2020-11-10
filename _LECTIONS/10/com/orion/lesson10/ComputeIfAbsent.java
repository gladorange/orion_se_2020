package com.orion.lesson10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComputeIfAbsent {



    class Person { String name; String departmentName;}

    public static void main(String[] args) {

        List<Person> persons = getPersons();
        Map<String, Set<Person>> departmentToPersons = new HashMap<>();

        for (Person person : persons) {
            departmentToPersons
                    .computeIfAbsent(person.departmentName, department -> new HashSet<>())
                    .add(person);

            /*departmentToPersons
                    .getOrDefault(person.departmentName, new HashSet<>()) - getOrDefault не изменяет HashMap, работать не будет
                    .add(person);
                    */
        }


    }

    private static List<Person> getPersons() {
        return null;
    }
}

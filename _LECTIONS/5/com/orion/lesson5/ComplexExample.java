package com.orion.lesson5;

import com.orion.lesson5.OrionException.CriticalLevel;

public class ComplexExample {


    public static void main(String[] args) {


        Person[] persons = {new Person("Vasya"), null, new Person("Petya"),};

        for (Person person : persons) {

            // открывает ересурс
            try {
                handlePerson(person);
            } catch (OrionException e) {
                if (e.getLevel() == CriticalLevel.IGNORE) {
                    System.out.println("Случилось исключение " + e.getMessage());
                }
            } finally {
                System.out.println("Конец итерации");
                // закрываете ресурс
            }
        }


        System.out.println("Конец программы");

    }

    private static void handlePerson(Person person) throws OrionException {

        if (person != null) {
            System.out.println(transformPersonName(person));
        } else {
            throw new OrionException("Человек - null", CriticalLevel.IGNORE);
        }
    }

    private static String transformPersonName(Person person) {
        return person.name.toUpperCase();
    }
}

package com.orion.lesson11;

import java.util.ArrayList;

import com.orion.lesson11.MethodReferences2.Person;

public class MethodRefernecesTriple {


    static class Triple {
        final Person person;
        final String nameToSet;
        final Integer ageToSet;

        Triple(Person person, String nameToSet, Integer ageToSet) {
            this.person = person;
            this.nameToSet = nameToSet;
            this.ageToSet = ageToSet;
        }

        @Override
        public String toString() {
            return "Triple{" +
                    "person=" + person +
                    '}';
        }
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
        public String toString() {
            return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }
    static class TripleList extends ArrayList<Triple> {

        public void forEachTriple(TripleHandler handler) {
            forEach(element -> handler.handle(element.person, element.nameToSet, element.ageToSet));
        }
    }

    public static void main(String[] args) {

        TripleList personsAndNames = new TripleList();

        personsAndNames.add(new Triple(new Person(), "Вася", 18));
        personsAndNames.add(new Triple(new Person(), "Петя", 23));
        personsAndNames.add(new Triple(new Person(), "Маша", 27));


        personsAndNames.forEachTriple(Person::setNameAndAge);

        System.out.println(personsAndNames);
    }

}

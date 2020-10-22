package com.orion.lesson4;

public class EnumMain {



    static class Person {
        String name;
        Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }


    public static void main(String[] args) {
        Person vasya = new Person("Vasya", Gender.MALE);
        Person masha = new Person("Masha", Gender.FEMALE);


        System.out.println(vasya);
        System.out.println(masha);


        System.out.println("Привет," + vasya.gender.getGreeting() + " " + vasya.name);
        System.out.println("Привет," + masha.gender.getGreeting() + " " + masha.name);

    }
}

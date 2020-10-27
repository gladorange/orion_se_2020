package com.orion.lesson6;

import java.lang.reflect.InvocationTargetException;

import com.orion.lesson6.Pair.Person;

public class Producer<T> {


    static class Animal {

        public Animal() {
        }
    }

    final private Class<T> clazz;

    public Producer(Class<T> clazz) {
        this.clazz = clazz;
    }


    T create() {
        try {
            return clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        Producer<Person> animalProducer = new Producer<>(Person.class);
        final Person person = animalProducer.create();
        final Person person1 = animalProducer.create();
        final Person person2 = animalProducer.create();


        System.out.println(person);
        System.out.println(person1);
        System.out.println(person2);


        System.out.println(new Producer<>(Animal.class).create());

    }
}

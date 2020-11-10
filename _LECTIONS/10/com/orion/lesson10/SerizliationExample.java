package com.orion.lesson10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerizliationExample {



    static class Person implements Serializable {
        String surname;

        public Person(String surname) {
            this.surname = surname;
        }
    }

    public static class Cat implements Serializable {
        String name;
        Person owner;

        public Cat(String name) {
            this.name = name;
        }

        public Person getOwner() {
            return owner;
        }

        public void setOwner(Person owner) {
            this.owner = owner;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cat barsik = new Cat("Barsik");
        barsik.setOwner(new Person("Петя"));
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("barsik.cat"))) {
            objectOutputStream.writeObject(barsik);
        }


       /* try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("barsik.cat"))) {
            final Object o = objectInputStream.readObject();
            if (o instanceof Cat) {
                System.out.println("Нашли кота!");
                System.out.println(((Cat) o).name);
            }
        }*/

    }
}

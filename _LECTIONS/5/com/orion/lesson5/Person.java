package com.orion.lesson5;

import java.util.Objects;

public class Person implements Cloneable{
    String name;

    public static int count = 0;

    public Person(String name) {
        if (name == null) {
            name = "";
        }


        System.out.println("Создаю экземпляр");
        count++;
        this.name = name;
    }


    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Меня собирает GC!");
        super.finalize();
    }


    @Override
    public boolean equals(Object o) {
        final Person o1 = (Person) o;
        return o1.name.equals(name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

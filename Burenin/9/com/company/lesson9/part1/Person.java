package com.company.lesson9.part1;

import com.company.lesson9.part1.annotations.XmlIgnore;
import com.company.lesson9.part1.annotations.XmlName;
import com.company.lesson9.part1.annotations.XmlTypeName;

@XmlTypeName("Человек")
class Person {

    @XmlName("Имя")
    String firstName;

    @XmlName("Возраст")
    int age;

    @XmlIgnore
    String password;

    public Person() {

    }

    public Person(String firstName, int age, String password) {
        this.firstName = firstName;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}

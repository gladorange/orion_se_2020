package com.druzhinin;

@XmlTypeName("Человек")
public class Person {

    @XmlName("Имя")
    private String name;

    @XmlName("Возраст")
    int age;

    @XmlIgnore
    String password;

    public Person() {
        this.name = "";
        this.age = 0;
        this.password = "";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.password = "******";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

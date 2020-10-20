package com.orion.lesson4;

public enum Gender {
    MALE("Мужской","Сеньор"),
    FEMALE("Женский","Мадам");

    final private String title;
    final private String greeting;

    Gender(String title, String greeting) {
        this.title = title;
        this.greeting = greeting;
    }


    @Override
    public String toString() {
        return title;
    }


    public String getGreeting() {
        return greeting;
    }
}




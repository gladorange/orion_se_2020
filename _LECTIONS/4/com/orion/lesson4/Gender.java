package com.orion.lesson4;

public enum Gender {
    MALE("Мужской"),
    FEMALE("Женский");


    final private String title;

    Gender(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return title;
    }
}




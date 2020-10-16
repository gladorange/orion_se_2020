package com.orion.lesson4;



/*public */class Person {

    String name;
    String lastName;
    Profession profession;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profession=" + profession +
                '}';
    }

    public Person(String name, String lastName, Profession profession) {
        this.name = name;
        this.lastName = lastName;
        this.profession = profession;
    }

    static class Profession {
        String title;
        String industry;

        public Profession(String title, String industry) {
            this.title = title;
            this.industry = industry;
        }


        @Override
        public String toString() {
            return "Profession{" +
                    "title='" + title + '\'' +
                    ", industry='" + industry + '\'' +
                    '}';
        }
    }

}

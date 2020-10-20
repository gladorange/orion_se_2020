package com.orion.lesson5;

import java.util.Objects;

public class PersonWithLastname extends Person {
    private final String lastname;

    public PersonWithLastname(String name, String lastname) {
        super(name);
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }


    @Override
    public boolean equals(Object o) {
        final PersonWithLastname o1 = (PersonWithLastname) o;
        return o1.name.equals(name)
                && o1.lastname.equals(lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lastname);
    }
}

package ru.localcat.task3;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private Set<Lection> lectionsList = new HashSet<>();

    public Student(String name, Set<Lection> lectionsList) {
        this.name = name;
        this.lectionsList = lectionsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lection> getLectionsList() {
        return lectionsList;
    }

    public void setLectionsList(Set<Lection> lectionsList) {
        this.lectionsList = lectionsList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lectionsList=" + lectionsList +
                "} \n";
    }
}

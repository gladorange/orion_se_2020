package lesson10.task3;

import java.util.Set;

public class Student {
    String name;
    Set<Lection> lections;

    public Student(String name, Set<Lection> lections) {
        this.name = name;
        this.lections = lections;
    }

    public Set<Lection> getLections() {
        return lections;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lections=" + lections +
                '}';
    }
}

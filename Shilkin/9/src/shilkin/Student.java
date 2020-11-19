package shilkin;

import java.time.LocalDate;
import java.util.Set;

public class Student {
    private final String name;
    private final Set<Lection> courses;

    public Student(String name,  Set<Lection> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public Set<Lection> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}

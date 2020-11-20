package shilkin.third;

import java.util.Set;

public class Student {
    private final String name;
    private final Set<Lecture> courses;

    public Student(String name, Set<Lecture> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public Set<Lecture> getCourses() {
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

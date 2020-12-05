package maxfomtaskeleven.firsttask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<Person> personsList = new ArrayList<>(
        Arrays.asList(new Person("Василий", 75), new Person("Дмитрий", 25), new Person("Денис", 23)));

        personsList.sort(Comparator.comparing(o -> o.name));
        System.out.println(personsList);

        personsList.sort(Comparator.comparing(o -> o.age));
        System.out.println(personsList);

    }
}



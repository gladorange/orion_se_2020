package shilkin.first;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class First {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Олег", 21));
        persons.add(new Person("Кирилл", 20));
        persons.add(new Person("Андрей", 35));
        persons.add(new Person("Алексей", 23));
        persons.add(new Person("Евгений", 23));
        persons.sort(Comparator.comparing(Person::getName));
        System.out.println(persons.toString());
        persons.sort(Comparator.comparing(Person::getAge));
        System.out.println(persons.toString());
    }
}

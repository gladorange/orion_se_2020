import java.util.*;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .toString();
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Dmitriy",26),
                new Person("Valera",17),
                new Person("Lana",35),
                new Person("Pasha",20),
                new Person("Dasha",11),
                new Person("Oleg",45)
        ));

        // sort by name
        Collections.sort(persons, Comparator.comparing(person -> person.getName()));
        System.out.println(persons);

        // sort by age
        Collections.sort(persons, Comparator.comparing(person -> person.getAge()));
        System.out.println(persons);
    }
}

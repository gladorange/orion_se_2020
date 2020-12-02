import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Person {

    String name;
    int age;

    Person(String name, int age) {
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
        return "Имя " + name + '\'' +
                ", возраст " + age;
    }

    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(new Person("Вася", 30));
        personArrayList.add(new Person("Миша", 33));
        personArrayList.add(new Person("Иван", 19));
        Collections.sort(personArrayList, Comparator.comparing(Person::getName));
        System.out.println(personArrayList);
        Collections.sort(personArrayList, Comparator.comparing(Person::getAge));
        System.out.println(personArrayList);


    }
}
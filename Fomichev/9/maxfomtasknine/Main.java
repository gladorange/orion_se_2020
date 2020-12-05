package maxfomtasknine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Person person = new Person("Коля", "Некрасов", 18);
        Sports hockey = new Sports("Пушкин", "Нападающий", 7);

        List<Object> list = new ArrayList<>(Arrays.asList(person, hockey));
        String s = Serializer.serialize(list);
        System.out.println(s);

        Person newPerson = (Person) Deserializer.deserialize(s, Person.class);
        System.out.println(newPerson);

        Sports newHockey = (Sports) Deserializer.deserialize(s, Sports.class);
        System.out.println(newHockey);
    }
}

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Student {
    final static int MIN_LECTIONS_NUMBER = 2;
    final static int MAX_LECTIONS_NUMBER = 5;
    final static int SORT_VALUE = 5;
    String name;
    HashSet<Lection> lectionSet = new HashSet<>();

    Student(String name) {
        this.name = name;
        randomInit();
    }

    public String getName() {
        return name;
    }

    public HashSet<Lection> getLectionSet() {
        return lectionSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", lectionSet=" + lectionSet +
                '}';
    }

    void randomInit() {
        int numberOfLections = ThreadLocalRandom.current().nextInt(MIN_LECTIONS_NUMBER, MAX_LECTIONS_NUMBER);
        for (int i = 0; i < numberOfLections; ++i) {
            boolean isContains = true;
            while (isContains) {
                final String lectionName = Lection.getRandomLection();
                isContains = lectionSet.stream().anyMatch(lection -> lection.getName().contains(lectionName));
                if (!isContains) {
                    lectionSet.add(new Lection(lectionName));
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Петя"));
        studentArrayList.add(new Student("Миша"));
        studentArrayList.add(new Student("Маша"));
        studentArrayList.add(new Student("Антон"));
        studentArrayList.add(new Student("Егор"));
        studentArrayList.add(new Student("Василиса"));
        studentArrayList.add(new Student("Галя"));
        studentArrayList.add(new Student("Степан"));
        studentArrayList.add(new Student("Иван"));
        studentArrayList.add(new Student("Андрей"));

        studentArrayList.stream().filter(student -> student.getLectionSet().stream()
                .anyMatch(lection -> lection.getName().contains(Lection.Lections.матанализ.name())))
                .forEach(student -> System.out.println(student.getName()));

        System.out.println(studentArrayList.stream().collect(Collectors.toMap(Student::getName, student -> student.getLectionSet().stream().count())));

        HashMap<String, Integer> map = new HashMap<>();
        studentArrayList.forEach(student -> student.getLectionSet().forEach(lection -> map.put(lection.getName(), map.getOrDefault(lection.getName(), 0) + 1)));
        System.out.println(map.entrySet().stream().filter(value -> value.getValue() > SORT_VALUE)
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue())));

        System.out.println(studentArrayList.stream().collect(Collectors.toMap(Student::getName, student -> student.getLectionSet().size()))
                .entrySet().stream().max(Comparator.comparing(x -> x.getValue())));

        HashMap<String, HashSet<String>> lessonsMap = new HashMap<>();
        studentArrayList.forEach(student -> student.getLectionSet().forEach(lection -> lessonsMap.computeIfAbsent(lection.getName(), v -> new HashSet<>()).add(student.getName())));
        System.out.println(lessonsMap);
    }
}

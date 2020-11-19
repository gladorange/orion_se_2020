package shilkin;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

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
        Calculator calc = new Calculator();
        calc.addOperation("Умножение", (a,b) -> a*b);
        calc.addOperation("Деление", (a,b) -> a/b);
        calc.addOperation("Сложение", Double::sum);
        calc.addOperation("Вычитание", (a,b) -> a-b);
        calc.addOperation("Возведение в степень", Math::pow);
        calc.addOperation("Извлечение корня степени n", (a,b) ->  Math.pow(a, 1.0/b));
        calc.calculate("Умножение", 2.0, 3.0);
        calc.calculate("Деление", 6.0, 3.0);
        calc.calculate("Деление", 6.0, 3.0);
        calc.calculate("Сложение", 1.0, 5.0);
        calc.calculate("Вычитание", 6.0, 2.0);
        calc.calculate("Возведение в степень", 2.0, 2.0);
        calc.calculate("Извлечение корня степени n", 4.0, 2.0);
        Student oleg = new Student("Олег", new HashSet<>(Arrays.asList(
                        new Lection("Матанализ", LocalDate.of(2020, 2, 1)),
                        new Lection("Философия", LocalDate.of(2020, 2, 2)),
                        new Lection("Физкультура", LocalDate.of(2020, 2, 5)))));
        Student andrey = new Student("Андрей", new HashSet<>(Arrays.asList(
                        new Lection("Философия", LocalDate.of(2020, 2, 2)),
                        new Lection("Физкультура", LocalDate.of(2020, 2, 5)))));
        Student kirill = new Student("Кирилл", new HashSet<>(Collections.singletonList(
                new Lection("Английкий язык", LocalDate.of(2020, 2, 3)))));
        Student sergey = new Student("Сергей", new HashSet<>(Arrays.asList(
                        new Lection("История", LocalDate.of(2020, 2, 4)),
                        new Lection("Физкультура", LocalDate.of(2020, 2, 5)))));
        Student alexey = new Student("Алексей", new HashSet<>(Arrays.asList(
                        new Lection("Физкультура", LocalDate.of(2020, 2, 5)),
                        new Lection("Английкий язык", LocalDate.of(2020, 2, 3)))));
        Student anton = new Student("Антон", new HashSet<>(Arrays.asList(
                        new Lection("Английкий язык", LocalDate.of(2020, 2, 3)),
                        new Lection("Матанализ", LocalDate.of(2020, 2, 1)))));
        Student nikolay = new Student("Николай", new HashSet<>(Arrays.asList(
                        new Lection("Матанализ", LocalDate.of(2020, 2, 1)),
                        new Lection("Физкультура", LocalDate.of(2020, 2, 5)))));
        Student anna = new Student("Аня", new HashSet<>(Arrays.asList(
                        new Lection("Английкий язык", LocalDate.of(2020, 2, 3)),
                        new Lection("История", LocalDate.of(2020, 2, 4)))));
        Student vera = new Student("Вера", new HashSet<>(Arrays.asList(
                        new Lection("Философия", LocalDate.of(2020, 2, 2)),
                        new Lection("Физкультура", LocalDate.of(2020, 2, 5)))));
        Student alex = new Student("Александр", new HashSet<>(Collections.singletonList(
                new Lection("Философия", LocalDate.of(2020, 2, 2)))));
        List<Student> students = new ArrayList<>(Arrays.asList(oleg, andrey, kirill, sergey, alexey, anton, nikolay, anna, vera, alex));
        System.out.println("Cписок студентов, которые хоть раз посещали матанализ: ");
        students
                .stream()
                .filter(Student -> Student.getCourses().stream()
                .anyMatch(Lection -> Lection.getName()
                .equals("Матанализ"))).forEach(Student -> System.out.println(Student.getName()));
        System.out.println("Статистика посещений для каждого студентам в формате: имя - количество посщенных лекций:");
        students
                .forEach(Student -> System.out.println(Student.getName() + " - " + Student.getCourses().size()));
        System.out.println("Название дисциплин, имеющих наибольшее количество посещений:");
        Map<String, Long> lectures = students
                                             .stream()
                                             .flatMap(Student -> Student.getCourses().stream())
                                             .collect(Collectors.groupingBy(Lection::getName, Collectors.counting()));
        Long maxLectures = Collections.max(lectures.values());
        for (Map.Entry<String, Long> entry : lectures.entrySet()) {
            if (entry.getValue().equals(maxLectures)){
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        System.out.println("Имена студентов, которые посетили наибольшее количество лекций в день:");
        Map<String, Integer> studentNames = students
                .stream()
                .collect((Collectors.toMap(Student::getName, Student -> Student.getCourses().size())));
        int maxSizeLections = Collections.max(studentNames.values());
        for (Map.Entry<String, Integer> entry : studentNames.entrySet()) {
            if (entry.getValue() == maxSizeLections){
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        System.out.println("Статистика по курсам:");
        Map<String, String> map = new HashMap<>();
        students
                .forEach(Student -> Student.getCourses()
                .forEach(Lection -> map.merge(Lection.getName(), String.format("%s ", Student.getName()), String::concat)));
        map.forEach((Student,Lection) -> System.out.printf("%s --- %s\n", Student, Lection));
    }
}

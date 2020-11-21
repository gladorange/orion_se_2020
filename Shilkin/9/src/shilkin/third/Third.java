package shilkin.third;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Third {
    public static void main(String[] args) {
        List<Student> students = getStudents();
        firstTask(students);
        secondTask(students);
        thirdTask(students);
        fourTask(students);
        fifthTask(students);
    }

    static void firstTask(List<Student> students) {
        System.out.println("Список студентов, которые хоть раз посещали матанализ: ");
        students
                .stream()
                .filter(student -> student.getCourses().stream().anyMatch(lecture -> lecture.getName().equals("Матанализ")))
                .forEach(student -> System.out.println(student.getName()));
    }

    static void secondTask(List<Student> students) {
        System.out.println("Статистика посещений для каждого студентам в формате: имя - количество посщенных лекций:");
        students.forEach(student -> System.out.println(student.getName() + " - " + student.getCourses().size()));
    }

    static void thirdTask(List<Student> students) {
        System.out.println("Название дисциплин, имеющих наибольшее количество посещений:");
        Map<String, Long> lectures = students
                .stream()
                .flatMap(student -> student.getCourses()
                        .stream())
                .collect(Collectors.groupingBy(Lecture::getName, Collectors.counting()));
        Long max = Collections.max(lectures.values());
        for (Map.Entry<String, Long> entry : lectures.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    static void fourTask(List<Student> students) {
        System.out.println("Имена студентов, которые посетили наибольшее количество лекций в один день:");
        Map<String, Long> dates = students
                .stream()
                .collect(Collectors.toMap(Student::getName, student -> student.getCourses()
                        .stream()
                        .collect(Collectors.groupingBy(Lecture::getDate, Collectors.counting()))
                        .entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .get()
                                .getValue()));
        Long max = Collections.max(dates.values());
        for (Map.Entry<String, Long> entry : dates.entrySet()) {
            if (entry.getValue().equals(max)) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    static void fifthTask(List<Student> students) {
        System.out.println("Статистика по курсам:");
        List<Triple<String, String, LocalDate>> triples = new ArrayList<>();
        for (Student student : students) {
            for (Lecture lecture : student.getCourses()) {
                Triple<String, String, LocalDate> triple = new Triple<>(student.getName(), lecture.getName(), lecture.getDate());
                triples.add(triple);
            }
        }
        List<String> lectureNames = new ArrayList<>();
        for (Triple<String, String, LocalDate> triple : triples) {
            if (!lectureNames.contains(triple.getSecond())) {
                lectureNames.add(triple.getSecond());
            }
        }
        Map<String, Integer> lectureStats = new HashMap<>();
        for (String lectureName : lectureNames) {
            List<String> names = new ArrayList<>();
            for (Triple<String, String, LocalDate> triple : triples) {
                if (triple.getSecond().equals(lectureName) && !names.contains(triple.getFirst())) {
                    names.add(triple.getFirst());
                }
            }
            lectureStats.put(lectureName, names.size());
        }
        for (Map.Entry<String, Integer> entry : lectureStats.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    static List<Student> getStudents() {
        Student oleg = new Student("Олег", new HashSet<>(Arrays.asList(
                new Lecture("Матанализ", LocalDate.of(2020, 2, 1)),
                new Lecture("Философия", LocalDate.of(2020, 2, 1)),
                new Lecture("Физкультура", LocalDate.of(2020, 2, 5)))));
        Student andrey = new Student("Андрей", new HashSet<>(Arrays.asList(
                new Lecture("Философия", LocalDate.of(2020, 2, 1)),
                new Lecture("Философия", LocalDate.of(2020, 2, 23)))));
        Student kirill = new Student("Кирилл", new HashSet<>(Collections.singletonList(
                new Lecture("Английкий язык", LocalDate.of(2020, 2, 3)))));
        Student sergey = new Student("Сергей", new HashSet<>(Arrays.asList(
                new Lecture("История", LocalDate.of(2020, 2, 4)),
                new Lecture("Физкультура", LocalDate.of(2020, 2, 5)))));
        Student alexey = new Student("Алексей", new HashSet<>(Arrays.asList(
                new Lecture("Физкультура", LocalDate.of(2020, 2, 5)),
                new Lecture("Английкий язык", LocalDate.of(2020, 2, 3)))));
        Student anton = new Student("Антон", new HashSet<>(Arrays.asList(
                new Lecture("Английкий язык", LocalDate.of(2020, 2, 3)),
                new Lecture("Матанализ", LocalDate.of(2020, 2, 1)))));
        Student nikolay = new Student("Николай", new HashSet<>(Arrays.asList(
                new Lecture("Матанализ", LocalDate.of(2020, 2, 1)),
                new Lecture("Физкультура", LocalDate.of(2020, 2, 5)))));
        Student anna = new Student("Аня", new HashSet<>(Arrays.asList(
                new Lecture("Английкий язык", LocalDate.of(2020, 2, 3)),
                new Lecture("История", LocalDate.of(2020, 2, 4)))));
        Student vera = new Student("Вера", new HashSet<>(Arrays.asList(
                new Lecture("Философия", LocalDate.of(2020, 2, 1)),
                new Lecture("Физкультура", LocalDate.of(2020, 2, 5)))));
        Student alex = new Student("Александр", new HashSet<>(Collections.singletonList(
                new Lecture("Философия", LocalDate.of(2020, 2, 2)))));
        return new ArrayList<>(Arrays.asList(oleg, andrey, kirill, sergey, alexey, anton, nikolay, anna, vera, alex));
    }
}

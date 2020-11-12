package shilkin.employees;

import shilkin.annotations.XmlIgnore;
import shilkin.annotations.XmlName;
import shilkin.annotations.XmlType;

@XmlType("Стажер")
public class Trainee {
    @XmlName("Имя")
    private final String name;
    @XmlName("Фамилия")
    private final String surname;
    @XmlName("Возраст")
    private final int age;
    @XmlName("Проект")
    private final String project;
    @XmlIgnore
    private final String password;

    public Trainee(String name, String surname, int age, String password, String project) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.password = password;
        this.project = project;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", project='" + project + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
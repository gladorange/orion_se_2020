package shilkin.employees;

import shilkin.annotations.XmlIgnore;
import shilkin.annotations.XmlName;
import shilkin.annotations.XmlType;

@XmlType("Наставник")
public class Tutor {
    @XmlName("Имя")
    private String name;
    @XmlName("Фамилия")
    private String surname;
    @XmlName("Возраст")
    private int age;
    @XmlName("Опыт")
    private int experience;
    @XmlIgnore
    private String password;

    public Tutor(String name, String surname, int age, int experience, String password) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = experience;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", experience=" + experience +
                '}';
    }
}
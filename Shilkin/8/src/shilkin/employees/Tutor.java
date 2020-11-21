package shilkin.employees;

import shilkin.annotations.XmlIgnore;
import shilkin.annotations.XmlName;
import shilkin.annotations.XmlType;

@XmlType("Tutor")
public class Tutor {
    @XmlName("name")
    private  String name;
    @XmlName("surname")
    private  String surname;
    @XmlName("age")
    private  int age;
    @XmlName("experience")
    private  int experience;
    @XmlIgnore
    private  String password;

    public Tutor() {
    }

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
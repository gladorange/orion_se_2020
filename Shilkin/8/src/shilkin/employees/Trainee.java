package shilkin.employees;

import shilkin.annotations.XmlIgnore;
import shilkin.annotations.XmlName;
import shilkin.annotations.XmlType;

@XmlType("Trainee")
public class Trainee {
    @XmlName("name")
    private  String name;
    @XmlName("surname")
    private  String surname;
    @XmlName("age")
    private  int age;
    @XmlName("project")
    private  String project;
    @XmlIgnore
    private  String password;

    public Trainee() {
    }

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
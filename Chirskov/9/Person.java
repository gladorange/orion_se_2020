@XmlTypeName("Человек")
public class Person {

    @XmlName("Имя")
    String name;

    @XmlName("Возраст")
    double age;

    @XmlIgnore
    String password;

    Person() {}

    Person(String name, double age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Имя " + name + '\'' +
                ", возраст " + age +
                ", пароль " + password;
    }
}
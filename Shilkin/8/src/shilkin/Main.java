package shilkin;

import shilkin.employees.Trainee;
import shilkin.employees.Tutor;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Tutor andrey = new Tutor("Андрей", "Тарасов", 35, 15, "12345678andrey");
        Trainee oleg = new Trainee("Олег", "Шилкин", 21, "oleg12", "Социальная сеть");
        Serializer serializer = new Serializer();
        String xmlAndrey = serializer.toSerializeObject(andrey);
        System.out.println(xmlAndrey);
        System.out.println(serializer.toDeserializeObject(xmlAndrey, Tutor.class));
        String xmlOleg = serializer.toSerializeObject(oleg);
        System.out.println(xmlOleg);
        System.out.println(serializer.toDeserializeObject(xmlOleg, Trainee.class));
    }
}

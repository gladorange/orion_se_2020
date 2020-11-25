package com.druzhinin;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException, NoSuchFieldException {
	// write your code here
        Person vasia = new Person("Вася", 12);
        Person petia = new Person("Петя", 24);

        String xmlVasia = "";
        String xmlPetia = "";
        XmlSerializer xmlSerializer = new XmlSerializer();
        try {
             xmlVasia = xmlSerializer.serialize(vasia);
             xmlPetia = xmlSerializer.serialize(petia);
        } catch (IllegalArgumentException | NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }

        Person newVasia = xmlSerializer.deserialize(xmlVasia, Person.class);
        System.out.println( newVasia.toString());
        Person newPetia = xmlSerializer.deserialize(xmlPetia, Person.class);
        System.out.println(newPetia.toString());

        Animal cat = new Animal("Барсик", "Бешеный");
        Animal newCat = xmlSerializer.deserialize(xmlSerializer.serialize(cat), Animal.class);
        System.out.println(newCat.toString());
    }
}

package shilkin;

import org.xml.sax.SAXException;
import shilkin.annotations.XmlIgnore;
import shilkin.annotations.XmlName;
import shilkin.annotations.XmlType;
import shilkin.employees.Trainee;
import shilkin.employees.Tutor;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    List<? super Object> myDeserializedList = new ArrayList<>();

    public static void main(String[] args) throws IllegalAccessException {
        Tutor Andrey = new Tutor("Андрей", "Тарасов", 35, 15, "piratvorobey12");
        Trainee Oleg = new Trainee("Олег", "Шилкин", 21, "hellodeartutor19", "Социальная сеть");
        List<? super Object> myList = new ArrayList<>();
        myList.add(Andrey);
        myList.add(Oleg);
        String xmlString = serializeCollection(myList);
        System.out.println(xmlString);

        List<? super Object> singleton = new ArrayList<>();
        singleton.add(Oleg);
        String singleObject = serializeCollection(singleton);
        System.out.println(singleObject);
        System.out.println(deserializeObject(singleObject).toString());
    }


    static String serializeCollection(Collection<?> elements) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        for (Object element : elements) {
            builder.append(serializeObject(element));
        }
        return builder.toString();
    }

    static String serializeObject(Object object) throws IllegalAccessException {
        StringBuilder output = new StringBuilder();
        final Class<?> myClass = object.getClass();
        String typeName = getTypeName(myClass);
        output.append("<" + typeName + "> \n");

        for (Field declaredField : myClass.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }
            declaredField.setAccessible(true);
            String fieldName = getFieldName(declaredField);
            output.append("<" + fieldName + ">" + declaredField.get(object).toString() + "</" + fieldName + ">\n");
        }
        output.append("</" + typeName + "> \n");
        return output.toString();
    }

    static String getTypeName(Class<?> myClass) {
        final XmlType annotation = myClass.getAnnotation(XmlType.class);
        if (annotation != null) {
            return annotation.value();
        }
        return myClass.getSimpleName();
    }

    static String getFieldName(Field declaredField) {
        final XmlName annotation = declaredField.getAnnotation(XmlName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return declaredField.getName();
    }

    static Object deserializeObject(String xmlObject) throws IllegalAccessException {
        String[] linesArray = xmlObject.split("\n");
        String objectType = linesArray[0].substring(linesArray[0].indexOf("<") + 1, linesArray[0].indexOf(">"));
        Object object = switch (objectType) {
            case "Наставник" -> new Tutor(null, null, 0, 0, null);
            case "Стажер" -> new Trainee(null, null, 0, null, null);
            default -> new Object();
        };
        Class<?> myClass = object.getClass();
        List<String> xmlFields = new ArrayList<>();
        for (int i = 1; i < linesArray.length - 1; i++) {
            String fieldValue = linesArray[i].substring(linesArray[i].indexOf(">") + 1, linesArray[i].indexOf("</"));
            xmlFields.add(fieldValue);
        }
        for (int i = 0; i < myClass.getDeclaredFields().length - 1; i++) {
            Field field = myClass.getDeclaredFields()[i];
            field.setAccessible(true);
            if (field.getType() == String.class) {
                field.set(object, Integer.valueOf(xmlFields.get(i)));
            } else {
                field.set(object, xmlFields.get(i));
            }
        }
        return object;
    }
}

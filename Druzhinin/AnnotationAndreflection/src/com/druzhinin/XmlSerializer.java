package com.druzhinin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class XmlSerializer {
    public String serialize(Object toSerialize) throws IllegalAccessException, NoSuchMethodException, IllegalArgumentException {
        StringBuilder output = new StringBuilder();
        final Class<?> annotationClass = toSerialize.getClass();

        boolean constructorsWithoutParameters = false;
        for (Constructor<?> constructor : annotationClass.getConstructors()) {
            if (constructor.getParameterCount() == 0) {
                constructorsWithoutParameters = true;
                break;
            }
        }

        if (!constructorsWithoutParameters) {
            throw new IllegalArgumentException("Невозможно сериализовать объект не имеющий конструктора без параметров");
        }

        String simpleName = getClassName(annotationClass);
        output.append("<" + simpleName + ">");

        for (Field field : annotationClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(XmlIgnore.class)) {
                continue;
            }

            field.setAccessible(true);
            String nameOfField = getFieldName(field);
            output.append("<" + nameOfField + ">" + field.get(toSerialize).toString() + "</" + nameOfField + ">");
        }
        output.append("</" + simpleName + ">");

        return output.toString();
    }

    // <Человек><Имя>Вася</Имя><Возраст>32</Возраст></Человек>
    public <T> T deserialize(String xmlString, Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        String header = "";
        if (xmlString.startsWith("<")) {
            int startHeaderIndex = xmlString.indexOf("<");
            int endHeaderIndex = xmlString.indexOf(">");

            header = xmlString.substring(startHeaderIndex + 1, endHeaderIndex);

            int closedHeaderTag = xmlString.lastIndexOf("</");
            xmlString = xmlString.substring(endHeaderIndex + 1, closedHeaderTag);

            String[] splitedStrings = xmlString.split("</.+?>"); // </Blablabla>
            ArrayList<String> splitedArray = new ArrayList<>(Arrays.asList(splitedStrings));

            Map<String, String> mapTagValue = new HashMap<String, String>();
            for (String pair : splitedArray) {
                int openedBracket = pair.indexOf('<');
                int closedBracket = pair.indexOf('>');

                String tag = pair.substring(openedBracket + 1, closedBracket);
                String value = pair.substring(closedBracket + 1);

                mapTagValue.put(tag, value);
            }

            T cast = clazz.getDeclaredConstructor().newInstance();
            for(Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                XmlName declaredAnnotation = field.getDeclaredAnnotation(XmlName.class);
                if (declaredAnnotation != null) {
                    String declaredAnnotationValue = declaredAnnotation.value();
                    String value = mapTagValue.get(declaredAnnotationValue);

                    if (value != null) {
                        if (field.getType().equals(String.class)) {
                            field.set(cast, value);
                        } else if (field.getType().equals(boolean.class)) {
                            field.set(cast, Boolean.parseBoolean(value));
                        } else if (field.getType().equals(int.class)) {
                            field.set(cast, Integer.parseInt(value));
                        } else if (field.getType().equals(double.class)) {
                            field.set(cast, Double.parseDouble(value));
                        }
                    }
                }
            }
            return cast;
        }
        return null;
    }

    private String getFieldName(Field field) {
        final XmlName annotation = field.getAnnotation(XmlName.class);
        if (annotation != null) {
            return annotation.value();
        }

        return field.getName();
    }

    private String getClassName(Class<?> clazz) {
        final XmlTypeName annotation = clazz.getAnnotation(XmlTypeName.class);
        if (annotation != null) {
            return annotation.value();
        }

        return clazz.getSimpleName();
    }
}

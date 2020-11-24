package com.company.lesson9.part1;

import com.company.lesson9.part1.annotations.XmlIgnore;

import java.lang.reflect.Field;
import java.util.Collection;

public class Serializer {

    public static String serialize(Collection<?> objects) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        if (objects.size() != 0) {
            builder.append("<Xml>\n");
            for (Object object : objects) {
                Class<?> aClass = object.getClass();
                final String objectName = Utils.getObjectName(aClass);
                builder.append("\t<" + objectName + ">\n");
                for (Field declaredField : aClass.getDeclaredFields()) {
                    if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                        continue;
                    }
                    declaredField.setAccessible(true);
                    final String fieldName = Utils.getFieldName(declaredField);
                    builder.append("\t\t<" + fieldName + ">" + declaredField.get(object).toString() + "</" + fieldName + ">\n");
                }
                builder.append("\t</" + objectName + ">\n");
            }
            builder.append("</Xml>\n");
        }
        return builder.toString();
    }
}

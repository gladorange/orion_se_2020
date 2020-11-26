package com.company.lesson9.part1;

import com.company.lesson9.part1.annotations.XmlIgnore;
import com.company.lesson9.part1.annotations.XmlName;
import com.company.lesson9.part1.annotations.XmlTypeName;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;

public class Utils {
    public static String getObjectName(Class<?> aClass) {
        final XmlTypeName annotation = aClass.getAnnotation(XmlTypeName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return aClass.getSimpleName();
    }

    public static String getFieldName(Field declaredField) {
        final XmlName annotation = declaredField.getAnnotation(XmlName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return declaredField.getName();
    }

    public static Document loadXMLFromString(String xml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }

    public static <T> T createObjectFromXml(NodeList fields, Class<T> aClass) throws IllegalAccessException, InstantiationException {
        T newInstance = aClass.newInstance();
        for (int i = 0; i < fields.getLength(); i++) {
            Node field = fields.item(i);
            for (Field declaredField : aClass.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(XmlIgnore.class)
                        || !Utils.getFieldName(declaredField).equals(field.getNodeName())) {
                    continue;
                }
                declaredField.setAccessible(true);
                if (declaredField.getType().isAssignableFrom(int.class)) {
                    declaredField.setInt(newInstance, Integer.parseInt(field.getTextContent()));
                } else if (declaredField.getType().isAssignableFrom(boolean.class)) {
                    declaredField.setBoolean(newInstance, Boolean.parseBoolean(field.getTextContent()));
                } else {
                    declaredField.set(newInstance, field.getTextContent());
                }
            }
        }
        return newInstance;
    }
}

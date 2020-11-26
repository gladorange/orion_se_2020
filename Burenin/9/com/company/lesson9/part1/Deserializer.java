package com.company.lesson9.part1;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Deserializer {
    public static <T> Collection<T> deserialize(String xmlStr, Class<T> aClass) {
        Collection<T> collection = new ArrayList<>();
        final String objectName = Utils.getObjectName(aClass);
        try {
            Document doc = Utils.loadXMLFromString(xmlStr);
            doc.getDocumentElement().normalize();
            NodeList objects = doc.getElementsByTagName(objectName);
            for (int i = 0; i < objects.getLength(); i++) {
                NodeList fields = objects.item(i).getChildNodes();
                try {
                    collection.add(Utils.createObjectFromXml(fields, aClass));
                } catch (IllegalAccessException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        return collection;
    }
}

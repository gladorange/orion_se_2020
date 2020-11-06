package ru.localcat.hw.xmlserializer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ru.localcat.hw.xmlserializer.annotations.XmlIgnore;
import ru.localcat.hw.xmlserializer.annotations.XmlName;
import ru.localcat.hw.xmlserializer.annotations.XmlTypeName;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLSerializer {

    private static String DOC_HEADER = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
    private static String TABULATOR = "\t";
    private static String NEW_LINE = "\n";

    public static <T> String serialize(Collection<T> objects, Class<T> clazz) {
        StringBuilder docResultBuilder = new StringBuilder();
        docResultBuilder.
                append(DOC_HEADER).
                append(NEW_LINE);

        if (objects != null && objects.size() > 0) {

            docResultBuilder
                    .append(TABULATOR)
                    .append("<")
                    .append(getTypeListName(getXMLEntityName(clazz)))
                    .append(">")
                    .append(NEW_LINE);

            for (T object : objects) {
                docResultBuilder
                        .append(TABULATOR).append(TABULATOR)
                        .append("<")
                        .append(getXMLEntityName(clazz))
                        .append(">")
                        .append(NEW_LINE);

                for (Field declaredField : clazz.getDeclaredFields()) {
                    if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                        continue;
                    }

                    declaredField.setAccessible(true);

                    docResultBuilder
                            .append(TABULATOR).append(TABULATOR).append(TABULATOR)
                            .append("<")
                            .append(getXMLPropertyName(declaredField))
                            .append(">");

                    try {
                        docResultBuilder.
                                append(declaredField.get(object).toString());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    docResultBuilder
                            .append("</")
                            .append(getXMLPropertyName(declaredField))
                            .append(">");

                    docResultBuilder.append(NEW_LINE);
                }

                docResultBuilder
                        .append(TABULATOR).append(TABULATOR)
                        .append("</")
                        .append(getXMLEntityName(clazz))
                        .append(">")
                        .append(NEW_LINE);
            }

            docResultBuilder
                    .append(TABULATOR)
                    .append("</")
                    .append(getTypeListName(getXMLEntityName(clazz)))
                    .append(">")
                    .append(NEW_LINE);
        }


        return docResultBuilder.toString();
    }

    public static <T> Collection<T> deserialize(String xmlText, Class<T> clazz) {
        if (!validateXMLDocSignature(xmlText, clazz)) {
            throw new RuntimeException("Not XML");
        }

        return getNodesList(xmlText, clazz);
    }

    private static String getTypeListName(String typeName) {
        return typeName + "s";
    }

    private static String getXMLEntityName(Class<?> clazz) {
        final XmlTypeName annotation = clazz.getAnnotation(XmlTypeName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return clazz.getSimpleName();
    }

    private static String getXMLPropertyName(Field declaredField) {
        final XmlName annotation = declaredField.getAnnotation(XmlName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return declaredField.getName();
    }

    private static boolean validateXMLDocSignature(String xmlContent, Class<?> clazz) {
        if (xmlContent.contains((CharSequence) DOC_HEADER)
                && xmlContent.contains((CharSequence) getXMLEntityName(clazz))
        ) {
            return true;
        }
        return false;
    }

    private static <T> Collection<T> getNodesList(String xmlDoc, Class<T> clazz) {

        // ????????????? норм так делать?
        Collection<T> resultList = new ArrayList<>();

        try {
            Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlDoc)));
            Element root = dom.getDocumentElement();

            for (Node node = root.getFirstChild(); node != null; node = node.getNextSibling()) {
                if (node.getNodeName().equals(getXMLEntityName(clazz))) {
                    try {
                        T generateFromClass = clazz.newInstance();

                        for (Node propetyNode = node.getFirstChild();
                             propetyNode != null;
                             propetyNode = propetyNode.getNextSibling()) {

                            for (Field declaredField : clazz.getDeclaredFields()) {
                                if (getXMLPropertyName(declaredField).equals(propetyNode.getNodeName())) {
                                    declaredField.setAccessible(true);

                                    if (declaredField.getType() == int.class) {
                                        declaredField.set(generateFromClass, Integer.parseInt(propetyNode.getTextContent()));
                                    }

                                    if (declaredField.getType() == float.class) {
                                        declaredField.set(generateFromClass, Float.parseFloat(propetyNode.getTextContent()));
                                    }

                                    if (declaredField.getType() == double.class) {
                                        declaredField.set(generateFromClass, Double.parseDouble(propetyNode.getTextContent()));
                                    }

                                    if (declaredField.getType() == boolean.class) {
                                        declaredField.set(generateFromClass, Boolean.parseBoolean(propetyNode.getTextContent()));
                                    }
                                    //Аналогично можно сделать и для остальных примитиво и типов
                                    if (declaredField.getType() == String.class) {
                                        declaredField.set(generateFromClass, propetyNode.getTextContent());
                                    }
                                }
                            }
                        }

                        resultList.add(generateFromClass);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}

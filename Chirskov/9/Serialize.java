import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

public class Serialize {

    final static String header = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";

    public static String serialize(Collection<?> objects) throws IllegalAccessException {
        if (objects.size() == 0)
            return "Empty size!";
        StringBuilder builder = new StringBuilder(header);
        builder.append("<Persons>\n");
        for (Object object : objects) {
            final Class<?> cls = object.getClass();
            final String objectName = getObjectName(cls);
            builder.append("<" + objectName + ">\n");
            for (Field declaredField : cls.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(XmlIgnore.class)) {
                    continue;
                }
                declaredField.setAccessible(true);
                final String fieldName = getFieldName(declaredField);
                builder.append("\t\t<" + fieldName + ">" + declaredField.get(object).toString() + "</" + fieldName + ">\n");
            }
            builder.append("</" + objectName + ">\n");
        }
        builder.append("</Persons>\n");
        return builder.toString();
    }

    public static <T> Collection<T> deserialize(String xml, Class<T> cls) throws ParserConfigurationException, IOException, SAXException, IllegalAccessException, InstantiationException {
        Collection<T> collection = new ArrayList<>();
        final String objectName = getObjectName(cls);
        if (!xml.contains(header) || !xml.contains(objectName))
            return collection;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        Document document = builder.parse(inputStream);

        NodeList objects = document.getElementsByTagName(objectName);
        for (int i = 0; i < objects.getLength(); ++i) {
            NodeList fields = objects.item(i).getChildNodes();
            T newInstance = cls.newInstance();
            for (int j = 0; j < fields.getLength(); ++j) {
                Node field = fields.item(j);
                for (Field declaredField : cls.getDeclaredFields()) {
                    if (declaredField.isAnnotationPresent(XmlIgnore.class)
                            || !getFieldName(declaredField).equals(field.getLocalName())) {
                        continue;
                    }
                    declaredField.setAccessible(true);
                    if (declaredField.getType().isAssignableFrom(double.class)) {
                        declaredField.setDouble(newInstance, Double.parseDouble(field.getTextContent()));
                    } else if (declaredField.getType().isAssignableFrom(boolean.class)) {
                        declaredField.setBoolean(newInstance, Boolean.parseBoolean(field.getTextContent()));
                    } else {
                        declaredField.set(newInstance, field.getTextContent());
                    }
                }
            }
            collection.add(newInstance);
        }
        return collection;
    }

    private static String getObjectName(Class<?> cls) {
        final XmlTypeName annotation = cls.getAnnotation(XmlTypeName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return cls.getSimpleName();
    }

    private static String getFieldName(Field declaredField) {
        final XmlName annotation = declaredField.getAnnotation(XmlName.class);
        if (annotation != null) {
            return annotation.value();
        }
        return declaredField.getName();
    }

    public static void main(String[] args) throws IllegalAccessException, ParserConfigurationException, InstantiationException, SAXException, IOException {
        Person vasya = new Person("Вася", 30, "Vasya30");
        Person misha = new Person("Миша", 33, "Misha33");
        Person ivan = new Person("Иван", 19, "Ivan19");
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(vasya);
        personList.add(misha);
        personList.add(ivan);

        final String serialize = serialize(personList);
        System.out.println(serialize);
        System.out.println(deserialize(serialize, Person.class));
    }
}

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

interface InitializerProducer {
}

class RandomGameInitializerProducer implements InitializerProducer {
    public static HashSet<Character> initCharacters() {
        HashSet<Character> characters = new HashSet<>();
        int maxCount = Character.getRandomNames().size();
        for (int i = 0; i < maxCount; ++i) {
            Character character = getRandomCharacter();
            character.setCurrentPosition(i);
            characters.add(character);
        }
        return characters;
    }

    public static Character getRandomCharacter() {
        int characterNumber = ThreadLocalRandom.current().nextInt(0, Character.getRandomNames().size());
        final String characterName = Character.getRandomNames().remove(characterNumber);
        return ThreadLocalRandom.current().nextBoolean() ? Monster.getMonster(characterName) : new Mage(characterName);
    }
}

class ReplayGameInitializerProducer implements InitializerProducer {
    public static Queue<SomeAction> initActions() {
        Queue<SomeAction> actions = new LinkedList<>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(WizardWars.FILENAME);
            Node root = document.getDocumentElement();
            NodeList books = root.getChildNodes();
            for (int i = 0; i < books.getLength() ; i++) {
                Node book = books.item(i);
                if (book.getNodeType() != Node.TEXT_NODE) {
                    if (book.getNodeName().equals(WizardWars.RESULT)) {
                        continue;
                    }
                    SomeAction action = book.getNodeName().equals(MageAction.class.getName()) ? new MageAction() : new MonsterAction();
                    NodeList bookProps = book.getChildNodes();
                    for (int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            if (bookProp.getChildNodes().item(0) == null) {
                                continue;
                            }
                            String value = bookProp.getChildNodes().item(0).getTextContent();
                            fillFields(action.getClass().getDeclaredFields(), bookProp, action, value);
                            fillFields(action.getClass().getSuperclass().getDeclaredFields(), bookProp, action, value);
                        }
                    }
                    actions.add(action);
                }
            }
        } catch (ParserConfigurationException | SAXException | IllegalAccessException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        return actions;
    }

    public static String getResult() {
        String result = null;
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(WizardWars.FILENAME);
            Node root = document.getDocumentElement();
            NodeList books = root.getChildNodes();
            for (int i = books.getLength() - 1; i > 0 ; i--) {
                Node book = books.item(i);
                if (book.getNodeType() != Node.TEXT_NODE) {
                    if (book.getNodeName().equals(WizardWars.RESULT)) {
                        result = book.getChildNodes().item(0).getTextContent();
                        break;
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        return result;
    }

    static void fillFields(Field[] declaredFields, Node bookProp, SomeAction action, String value) throws IllegalAccessException {
        for (Field declaredField : declaredFields) {
            if (!bookProp.getNodeName().equals(declaredField.getName())) {
                continue;
            }
            declaredField.setAccessible(true);
            if (declaredField.getType().isAssignableFrom(int.class)) {
                declaredField.setInt(action, Integer.parseInt(value));
            } else {
                declaredField.set(action, value);
            }
        }
    }
}

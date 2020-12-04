import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

interface ActionProducer {
    HashSet<Character> characters = new HashSet<>();
    Queue<SomeAction> actions = new LinkedList<>();
    void play();
    void initCharacters();
    default HashSet<Character> getCharacters() {
        return characters;
    }

    default Queue<SomeAction> getActions() {
        return actions;
    }
}

class RandomGameActionProducer implements ActionProducer {
    public void play() {
        //шоу матч без победителей :D
        while (characters.size() > 1) {
            for (final Character character : characters) {
                SomeAction action = character.getClass() == Mage.class ? new MageAction(): new MonsterAction();
                character.play(characters, action);
                actions.add(action);
            }
            deleteDeadCharacters();
        }
        if (characters.size() == 1) {
            Character character = (Character)characters.toArray()[0];
            System.out.println("Персонаж " + character.getName() + " всех победил");
        }
        else {
            System.out.println("Победителей нет!");
        }
    }

    public void initCharacters() {
        int maxCount = Character.getRandomNames().size();
        for (int i = 0; i < maxCount; ++i) {
            Character character = getRandomCharacter();
            character.setCurrentPosition(i);
            characters.add(character);
        }
    }

    public static Character getRandomCharacter() {
        int characterNumber = ThreadLocalRandom.current().nextInt(0, Character.getRandomNames().size());
        final String characterName = Character.getRandomNames().remove(characterNumber);
        return ThreadLocalRandom.current().nextBoolean() ? Monster.getMonster(characterName) : new Mage(characterName);
    }

    static void deleteDeadCharacters() {
        final Iterator iterator = characters.iterator();
        while (iterator.hasNext()) {
            final Character character = (Character)iterator.next();
            final boolean isDead = character.getCurrentHealth() <= 0;
            if (isDead) {
                System.out.println(new StringBuilder().append(character.getName()).append(" убит").toString());
                iterator.remove();
            }
        }
    }
}

class ReplayActionProducer implements ActionProducer {
    public void play() {
        for (SomeAction action : actions) {
            String print = action.getActingCharacter() + " наносит " + action.getDamage() + " единиц урона " + action.getTargetCharacter();
            if (action instanceof MageAction) {
                ((MageAction) action).getSpell();
                System.out.println(print + " заклинанием " + ((MageAction) action).getSpell());
            }
            else {
                System.out.println(print);
            }
        }
    }

    public void initCharacters() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(WizardWars.filename);
            Node root = document.getDocumentElement();
            NodeList books = root.getChildNodes();
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                if (book.getNodeType() != Node.TEXT_NODE) {
                    SomeAction action = book.getNodeName() == MageAction.class.getName() ? new MageAction() : new MonsterAction();
                    NodeList bookProps = book.getChildNodes();
                    for(int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            if (bookProp.getChildNodes().item(0) == null) {
                                continue;
                            }
                            String value = bookProp.getChildNodes().item(0).getTextContent();
                            for (Field declaredField : action.getClass().getDeclaredFields()) {
                                declaredField.setAccessible(true);
                                if (declaredField.getType().isAssignableFrom(int.class)) {
                                    declaredField.setInt(action, Integer.parseInt(value));
                                } else {
                                    declaredField.set(action, value);
                                }
                            }
                            actions.add(action);
                        }
                    }
                }
            }

        } catch (ParserConfigurationException | SAXException | IllegalAccessException | IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}

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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

interface ActionProducer {
    void play();
}

class RandomGameActionProducer implements ActionProducer {
    private HashSet<Character> characters;
    private String info;
    private Queue<SomeAction> actions = new LinkedList<>();

    RandomGameActionProducer(HashSet<Character> characters) {
        this.characters = characters;
    }

    public String getInfo() {
        return info;
    }

    public Queue<SomeAction> getActions() {
        return actions;
    }

    public void play() {
        while (characters.size() > 1) {
            for (final Character character : characters) {
                SomeAction action = character.getClass() == Mage.class ? new MageAction() : new MonsterAction();
                character.play(characters, action);
                if (action != null) {
                    actions.add(action);
                }
            }
            deleteDeadCharacters();
        }
        if (characters.size() == 1) {
            info = "Персонаж " + ((Character) characters.toArray()[0]).getName() + " всех победил";
        } else {
            info = "Победителей нет!";
        }
        System.out.println(info);
    }

    void deleteDeadCharacters() {
        final Iterator iterator = characters.iterator();
        while (iterator.hasNext()) {
            final Character character = (Character) iterator.next();
            final boolean isDead = character.getCurrentHealth() <= 0;
            if (isDead) {
                System.out.println(new StringBuilder().append(character.getName()).append(" убит").toString());
                iterator.remove();
            }
        }
    }
}

class ReplayActionProducer implements ActionProducer {
    private Queue<SomeAction> actions;

    ReplayActionProducer(Queue<SomeAction> actions) {
        this.actions = actions;
    }

    public void play() {
        for (SomeAction action : actions) {
            String print = action.getActingCharacter() + " наносит " + action.getDamage() + " единиц урона " + action.getTargetCharacter();
            if (action instanceof MageAction) {
                ((MageAction) action).getSpell();
                System.out.println(print + " заклинанием " + ((MageAction) action).getSpell());
            } else {
                System.out.println(print);
            }
        }
        System.out.println(ReplayGameInitializerProducer.getResult());
    }

    public void initCharacters() {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(WizardWars.FILENAME);
            Node root = document.getDocumentElement();
            NodeList books = root.getChildNodes();
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                if (book.getNodeType() != Node.TEXT_NODE) {
                    SomeAction action = book.getNodeName() == MageAction.class.getName() ? new MageAction() : new MonsterAction();
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

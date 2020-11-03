import java.util.concurrent.ThreadLocalRandom;

public enum Element {
    BUTTON(Button.class), CHECKBOX(CheckBox.class), TEXTFIELD(TextField.class);
    private Class<? extends Rectangle> type;
    private Element(Class<? extends Rectangle> type) {
        this.type = type;
    }

    public Rectangle createElement() {
        try {
            return type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(type + " не имеет конструктора по умолчанию");
        }
    }

    static public Rectangle createRandomElement() {
        Element elem = Element.values()[ThreadLocalRandom.current().nextInt(0, Element.values().length)];
        return elem.createElement();
    }
}
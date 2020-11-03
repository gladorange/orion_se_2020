import java.util.HashSet;

public class UI {
    static final int MAX_X = 100;
    static final int MAX_Y = 100;
    private HashSet<Rectangle> elements = new HashSet<>();
    public HashSet<Rectangle> getAllElements(){
        return elements;
    }
    void addElement(Rectangle element) throws ElementsOverlapException, ElementsOutOfScene, NullPointerException {
        if (element == null) {
            throw new NullPointerException();
        }

        int startX = element.x;
        int startY = element.y;
        int endX = startX + element.width;
        int endY = startY + element.height;

        if (endX > UI.MAX_X || endY > UI.MAX_Y) {
            throw new ElementsOutOfScene("Элемент " + element + " не может быть добавлен, потому что выходит за пределы сцены");
        }
        for (Rectangle rectangle : elements) {
            if ((rectangle.x > startX && rectangle.width + rectangle.x < endX)
                || (rectangle.y > startY && rectangle.height + rectangle.y < endY)) {
                throw new ElementsOverlapException("Элемент " + element + " не может быть добавлен, потому что пересекается с элементом " + rectangle);
            }
        }
        elements.add(element);
    }

    public static class ElementsOverlapException extends Exception {
        public ElementsOverlapException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static class ElementsOutOfScene extends Exception {
        public ElementsOutOfScene(String errorMessage) {
            super(errorMessage);
        }
    }
}

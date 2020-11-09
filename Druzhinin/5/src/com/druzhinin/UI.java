package com.druzhinin;

public class UI {
    final private int width = 100;
    final private int height = 100;

    private Rectangle[] elements;

    public UI() {
        elements = new Rectangle[0];
    }

    public UI(int numberOfElements) {
        elements = new Rectangle[numberOfElements];
    }

    public Rectangle[] getAllElements() {
        return elements;
    }

    public void addElement(Rectangle element) {
        if (element.getX() < 0 | element.getX() + element.getWidth() > width
        | element.getY() < 0 | element.getY() + element.getHeight() > height) {
            throw new ElementsOverlapException("Элемент вне поля");
        }

        if (isIntersection(element)) {
            throw new ElementsOverlapException("Элементы пересекаются");
        }

        Rectangle[] temporaryArray = new Rectangle[elements.length + 1];

        System.arraycopy(elements, 0, temporaryArray, 0, elements.length);
        elements = temporaryArray;
        elements[elements.length - 1] = element;
    }

    private boolean isIntersection(Rectangle element) {
        for (int i = 0; i < elements.length; i++) {
            Rectangle rectA = elements[i]; // static already exist
            int rectAx1 = rectA.getX();
            int rectAx2 = rectA.getX() + rectA.getWidth();
            int rectAy1 = rectA.getY();
            int rectAy2 = rectA.getY() + rectA.getHeight();

            Rectangle rectB = element;
            int rectBx1 = rectB.getX();
            int rectBx2 = rectB.getX() + rectB.getWidth();
            int rectBy1 = rectB.getY();
            int rectBy2 = rectB.getY() + rectB.getHeight();

            if (!(rectBx2 < rectAx1 |      // leftward
                    rectBx1 > rectAx2 |  // rightward
                    rectBy2 < rectAy1 |  // higher
                    rectBy1 > rectAy2)) { // lower
                System.out.printf("Пересечение с элементом %s", rectA.getCaption());
                return true;
            }
        }
        return false;
    }
}

package shilkin;

public class UI {
    private Rectangle[] elements;

    public Rectangle[] getAllElements() {
        return this.elements;
    }

    public void addElement(Rectangle rectangle) throws ElementsOverlapException {
        int count;
        if (this.elements == null) {
            count = 0;
        } else {
            count = this.elements.length;
        }
        if (count != 0) {
            if (isIntersects(rectangle).equals("")) {
                Rectangle[] temporaryArray = new Rectangle[count + 1];
                for (int i = 0; i < count; i++) {
                    temporaryArray[i] = this.elements[i];
                }
                temporaryArray[count] = rectangle;
                this.elements = temporaryArray;
            } else {
                throw new ElementsOverlapException("Элемент " + rectangle.caption + " не может быть добавлен, т.к. пересекается с элементом " + isIntersects(rectangle));
            }
        } else{
            Rectangle[] temporaryArray = new Rectangle[count + 1];
            for (int i = 0; i < count; i++) {
                temporaryArray[i] = this.elements[i];
            }
            temporaryArray[count] = rectangle;
            this.elements = temporaryArray;
        }

    }

    private String isIntersects(Rectangle rectangle) {
        String captionInterElement = "";
        for (int i = 0; i < this.elements.length; i++) {
            if ((rectangle.x < this.elements[i].x + this.elements[i].width) && (rectangle.x + rectangle.width > this.elements[i].x)
                    && (rectangle.y < this.elements[i].y + this.elements[i].height) && (rectangle.y + rectangle.height > this.elements[i].y)) {
                captionInterElement = this.elements[i].caption;
                break;
            }
        }
        return captionInterElement;
    }
}

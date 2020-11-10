package shilkin;

public class UI {

    private Rectangle[] elements;

    public Rectangle[] getAllElements() {
        return this.elements;
    }

    public void addElement(Rectangle rectangle) throws ElementsOverlapException, OutOfSceneException {
        if (this.elements == null) {
            Rectangle[] temporaryArray = new Rectangle[1];
            temporaryArray[0] = rectangle;
            this.elements = temporaryArray;
            return;
        }

        if (getOutScene(rectangle)) {
            throw new OutOfSceneException("Элемент " + rectangle.caption + " не может быть добавлен, т.к. выходит за границы сцены");
        }
        if (getIntersection(rectangle).isIntersect()) {
            throw new ElementsOverlapException("Элемент " + rectangle.caption + " не может быть добавлен, т.к. пересекается с элементом " + getIntersection(rectangle).getElement());
        }

        Rectangle[] temporaryArray = new Rectangle[this.elements.length + 1];
        System.arraycopy(this.elements, 0, temporaryArray, 0, this.elements.length);
        temporaryArray[this.elements.length] = rectangle;
        this.elements = temporaryArray;
    }

    private InterCheckResult getIntersection(Rectangle rectangle) {
        InterCheckResult checkResult = new InterCheckResult();
        for (Rectangle element : this.elements) {
            if ((rectangle.x < element.x + element.width) && (rectangle.x + rectangle.width > element.x)
                    && (rectangle.y < element.y + element.height) && (rectangle.y + rectangle.height > element.y)) {
                checkResult.setElement(element.caption);
                checkResult.setIntersect(true);
                break;
            }
        }
        return checkResult;
    }

    boolean getOutScene(Rectangle rectangle){
        int maxX = 100;
        int maxY = 100;
        return (rectangle.x + rectangle.width > maxX) || (rectangle.x + rectangle.height > maxY);
    }
}

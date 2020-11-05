public class TextField extends Rectangle {
    String text = getRandomString();
    TextField() {
    }
    TextField(String caption, int x, int y, int height, int width) {
        super(caption, x, y, height, width);
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return  "Текстовое поле " + super.caption + " в <" + x + "," + y
                + "> с высотой: " + height + " и шириной: " + width;
    }
}

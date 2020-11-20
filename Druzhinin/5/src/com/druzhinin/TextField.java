package com.druzhinin;

public class TextField extends Rectangle {
    private String enteredText;

    public TextField() {
    }

    public TextField(int x, int y, int width, int height, String caption, boolean active, String enteredText) {
        super(new Point(x, y), width, height, caption, active);
        this.enteredText = enteredText;
    }

    public String getEnteredText() {
        return enteredText;
    }

    public void setEnteredText(String enteredText) {
        this.enteredText = enteredText;
    }

    @Override
    public String toString() {
        return "TextField{" +
                "enteredText='" + enteredText + '\'' +
                ", point=" + point +
                ", width=" + width +
                ", height=" + height +
                ", caption='" + caption + '\'' +
                ", active=" + active +
                '}';
    }
}

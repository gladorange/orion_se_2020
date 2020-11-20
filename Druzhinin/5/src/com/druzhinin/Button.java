package com.druzhinin;

public class Button extends Rectangle implements Clickable {
    private final int id;
    private static int iD = 0;

    ButtonClickCallback callback;

    public Button() {
        iD++;
        id = iD;
    }

    public Button(int x, int y, int width, int height, String caption, boolean active, ButtonClickCallback callback) {
        super(new Point(x, y), width, height, caption, active);

        this.callback = callback;
        iD++;
        id = iD;
    }

    @Override
    public void click() {
        if (!active) {
            throw new ReadOnlyException("Can not change inactive state for Button with id = " + id);
        } else {
            callback.onButtonClick();
            System.out.println("Нажата кнопка с id: " + id);
        }
    }

    @Override
    public String toString() {
        return "Button{" +
                "id=" + id +
                ", point=" + point +
                ", width=" + width +
                ", height=" + height +
                ", caption='" + caption + '\'' +
                ", active=" + active +
                '}';
    }
}

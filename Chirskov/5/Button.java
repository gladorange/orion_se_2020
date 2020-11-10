class Button extends Rectangle {
    ButtonClickCallback callback;

    Button() {
    }
    Button(String caption, int x, int y, int height, int width, ButtonClickCallback callback) {
        super(caption, x, y, height, width);
        this.callback = callback;
    }

    public void setCallback(ButtonClickCallback callback) {
        this.callback = callback;
    }

    public ButtonClickCallback getCallback() {
        return callback;
    }

    @Override
    public void click() {
        try {
            super.click();
            callback.onButtonClick();
        } catch (ReadOnlyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Кнопка с названием " + super.caption + " в <" + x + "," + y
                + "> с высотой: " + height + " и шириной: " + width;
    }
}

package shilkin;

public class TextField extends Rectangle {

    private String inputText;

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getInputText() {
        return inputText;
    }

    public TextField(int x, int y, int height, int width, String caption, boolean isEnabled, String inputText) {
        super(x, y, height, width, caption, isEnabled);
        this.inputText = inputText;
    }

    @Override
    public String toString() {
        return "Текстовое поле " + "в кооординатах " + x + "," + y + ", высота = " + height + ", ширина = " + width + ", название: " + caption;
    }
}

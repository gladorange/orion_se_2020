package shilkin;

public class CheckBox extends Rectangle implements Clickable {

    private boolean isPressed;

    public CheckBox(int x, int y, int height, int width, String caption, boolean isEnabled, boolean isPressed) {
        super(x, y, height, width, caption, isEnabled);
        this.isPressed = isPressed;
    }

    public boolean isPressed() {
        return isPressed;
    }

    @Override
    public void click() {
        this.isPressed = !this.isPressed;
    }

    @Override
    public String toString() {
        return "Галка " + "в кооординатах " + x + ", " + y + ", высота = " + height + ", ширина = " + width + ", название: " + caption;
    }
}

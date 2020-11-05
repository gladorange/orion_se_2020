package shilkin;

public class Rectangle implements Clickable {
    protected final int x;
    protected final int y;
    protected final int height;
    protected final int width;
    protected final String caption;
    protected final boolean isEnabled;

    public Rectangle(int x, int y, int height, int width, String caption, boolean isEnabled) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.caption = caption;
        this.isEnabled = isEnabled;
    }

    @Override
    public void click() {

    }
}


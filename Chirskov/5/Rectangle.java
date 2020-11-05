import java.util.concurrent.ThreadLocalRandom;

abstract class Rectangle implements Clickable {
    static final int LEFT_LIMIT = 97; // letter 'a'
    static final int RIGHT_LIMIT = 123; // letter 'z'
    static final int MAX_STRING_LENGTH = 11;
    static final int MAX_HEIGHT = 10;
    static final int MAX_WIDTH = 10;
    int x;
    int y;
    int height;
    int width;
    String caption;
    private boolean state = true;

    Rectangle() {
        x = ThreadLocalRandom.current().nextInt(1, UI.MAX_X);
        y = ThreadLocalRandom.current().nextInt(1, UI.MAX_Y);
        height = ThreadLocalRandom.current().nextInt(1, MAX_HEIGHT);
        width = ThreadLocalRandom.current().nextInt(1, MAX_WIDTH);
        this.caption = getRandomString();
    }

    Rectangle(String caption, int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.caption = caption;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    @Override
    public void click() throws ReadOnlyException {
        if (!state) {
            throw new ReadOnlyException("Элемент " + this + " выключен");
        }
    }

    public static String getRandomString() {
        int stringLength = ThreadLocalRandom.current().nextInt(1, MAX_STRING_LENGTH);
        String randomString = ThreadLocalRandom.current().ints(LEFT_LIMIT, RIGHT_LIMIT).limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return randomString;
    }

    public static class ReadOnlyException extends Exception {
        public ReadOnlyException(String errorMessage) {
            super(errorMessage);
        }
    }
}

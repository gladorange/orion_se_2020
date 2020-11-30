package maxfomtaskfive;

public interface Clickable {
    void click();

    default void isElementActive(boolean isOn) throws ReadOnlyException {
        if (!isOn) {
            throw new ReadOnlyException();
        }
    }
}

package maxfomtaskfive;

public class ReadOnlyException extends Exception {
    public ReadOnlyException() {
        super("Элемент только для чтения!");
    }
}

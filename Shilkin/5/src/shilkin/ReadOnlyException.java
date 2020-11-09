package shilkin;

public class ReadOnlyException extends Exception{
    public ReadOnlyException(String message) {
        super(message);
    }
}

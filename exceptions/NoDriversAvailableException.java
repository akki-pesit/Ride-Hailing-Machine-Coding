package exceptions;

public class NoDriversAvailableException extends Exception {
    public NoDriversAvailableException() {
        super("No drivers found");
    }
}

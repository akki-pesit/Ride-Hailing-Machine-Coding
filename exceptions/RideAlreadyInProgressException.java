package exceptions;

public class RideAlreadyInProgressException extends Exception{
    public RideAlreadyInProgressException(String errorMessage) {
        super(errorMessage);
    }
}

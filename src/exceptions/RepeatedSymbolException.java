package exceptions;

public class RepeatedSymbolException extends RuntimeException {
    public RepeatedSymbolException(String message) {
        super(message);
    }
}

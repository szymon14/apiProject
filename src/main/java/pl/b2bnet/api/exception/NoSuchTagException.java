package pl.b2bnet.api.exception;

public class NoSuchTagException extends RuntimeException {
    public NoSuchTagException(String text) {
        super(text);
    }
}

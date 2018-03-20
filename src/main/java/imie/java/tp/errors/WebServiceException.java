package imie.java.tp.errors;

public abstract class WebServiceException extends RuntimeException {
    protected WebServiceException(String message) {
        super(message);
    }

    protected WebServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

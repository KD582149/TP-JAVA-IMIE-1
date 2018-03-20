package imie.java.tp.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadParametersException extends WebServiceException {
    public BadParametersException(String message) {
        super(message);
    }

    public BadParametersException(String message, Throwable cause) {
        super(message, cause);
    }
}

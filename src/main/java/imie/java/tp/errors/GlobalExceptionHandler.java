package imie.java.tp.errors;

import imie.java.tp.utils.MapBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice(basePackages = "imie.java.tp.controllers")
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(WebServiceException.class)
    ResponseEntity handleWSExceptions(WebServiceException ex) {
        HttpStatus status = ex.getClass().isAnnotationPresent(ResponseStatus.class) ?
                ex.getClass().getAnnotation(ResponseStatus.class).value() : INTERNAL_SERVER_ERROR;

        return ResponseEntity
                .status(status)
                .body(MapBuilder.instance()
                    .put("message", ex.getMessage())
                    .put("datetime", ISO_DATE_TIME.format(now()))
                    .build());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    ResponseEntity handleWSExceptions(HttpMessageNotReadableException ex) {
        logger.error("The request is not valid", ex);
        return handleWSExceptions(new BadRequestException("The request is not valid : " + ex.getMessage()));

    }

}

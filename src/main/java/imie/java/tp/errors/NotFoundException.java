package imie.java.tp.errors;

import imie.java.tp.model.Identifiable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends WebServiceException {

    private static final String ERROR_MESSAGE = "La ressource de type %s portant l'identifiant '%s' n'existe pas.";

    public <ID extends Serializable> NotFoundException(ID resId, Class<? extends Identifiable<ID>> resType) {
        super(String.format(ERROR_MESSAGE, resType.getSimpleName(), resId.toString()));
    }
}

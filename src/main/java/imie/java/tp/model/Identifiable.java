package imie.java.tp.model;

import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

public interface Identifiable<ID extends Serializable> extends Serializable {
    @JsonView(Views.Public.class)
    ID getId();

    void setId(ID id);
}

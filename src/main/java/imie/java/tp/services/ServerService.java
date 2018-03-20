package imie.java.tp.services;

import imie.java.tp.errors.NotFoundException;
import imie.java.tp.model.entities.Server;
import imie.java.tp.repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static imie.java.tp.utils.GeneralUtils.fromIterable;

@Service
public class ServerService {

    private final ServerRepository repository;

    @Autowired
    public ServerService(ServerRepository repository) {
        this.repository = repository;
    }

    public List<Server> findAll() {
        return fromIterable(repository.findAll(), ArrayList::new);
    }

    public Server find(Integer id) throws NotFoundException {
        if (!repository.exists(id)) {
            throw new NotFoundException(id, Server.class);
        }
        return repository.findOne(id);
    }
}

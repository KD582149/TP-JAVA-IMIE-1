package imie.java.tp.controllers;

import imie.java.tp.model.Server;
import imie.java.tp.repositories.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ServerRepository serverRepository;

    @RequestMapping("/servers")
    public List<Server> findserver () {
        return fromIterable(serverRepository.findAll());

    }

    private static <E> List<E> fromIterable(Iterable<E> iterable) {
        List<E> results = new ArrayList<>();
        iterable.iterator().forEachRemaining(results::add);
        return results;
    }
}

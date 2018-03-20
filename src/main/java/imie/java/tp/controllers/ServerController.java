package imie.java.tp.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import imie.java.tp.model.Views;
import imie.java.tp.model.dto.ServerTO;
import imie.java.tp.model.mappers.ServerMapper;
import imie.java.tp.services.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/servers")

public class ServerController {

    private final ServerService service;
    private final ServerMapper mapper;

    @Autowired
    public ServerController(ServerService service) {
        this.service = service;
        this.mapper = new ServerMapper();
    }

    @JsonView(Views.Server.class)
    @GetMapping("{id}")
    ServerTO getServer(@PathVariable Integer id) {
        return mapper.map(service.find(id));
    }

    @JsonView(Views.Server.class)
    @GetMapping
    List<ServerTO> getServers() {
        return mapper.map(service.findAll());
    }
}

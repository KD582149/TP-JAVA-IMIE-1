package imie.java.tp.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import imie.java.tp.model.Views;
import imie.java.tp.model.dto.MonitoringTO;
import imie.java.tp.model.mappers.MonitoringMapper;
import imie.java.tp.services.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitorings")
public class MonitoringController {

    private final MonitoringService service;
    private final MonitoringMapper mapper;

    @Autowired
    public MonitoringController(MonitoringService service) {
        this.service = service;
        this.mapper = new MonitoringMapper();
    }

    @GetMapping("{id}")
    @JsonView(Views.Monitoring.class)
    MonitoringTO getMonitoring(@PathVariable Integer id) {
        return mapper.map(service.find(id));
    }

    @GetMapping
    @JsonView(Views.Monitoring.class)
    List<MonitoringTO> getMonitorings(
        @RequestParam(required = false) String before,
        @RequestParam(required = false) String after
    ) {

        return mapper.map(service.findAll(before, after));
    }
}

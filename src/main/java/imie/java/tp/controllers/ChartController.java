package imie.java.tp.controllers;

import imie.java.tp.model.entities.ChartType;
import imie.java.tp.model.entities.Monitoring;
import imie.java.tp.services.MonitoringService;
import imie.java.tp.services.charts.ChartData;
import imie.java.tp.services.charts.adapters.NgxChartAdapter;
import imie.java.tp.services.charts.adapters.NgxChartData;
import imie.java.tp.services.charts.configurations.ChartConfiguration;
import imie.java.tp.services.charts.configurations.ChartConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/charts")
public class ChartController {

    private final MonitoringService service;

    @Autowired
    public ChartController(MonitoringService service) {
        this.service = service;
    }

    @RequestMapping("test")
    NgxChartData chartTest() {
        ChartConfiguration<Monitoring> cpuUsage = ChartConfigurator.newConfigurator(Monitoring.class)
                .name("Utilisation CPU")
                .abscissa(Monitoring::getTime)
                .chartType(ChartType.LINE_CHART)
                .serie("CPU #0", Monitoring::getCpu0)
                .build();

        ChartData data = cpuUsage.getProcessor().process(service.findAllPaged(0, 200));
        return new NgxChartAdapter().adapt(data);
    }
}

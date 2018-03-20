package imie.java.tp.model.dto;

import com.fasterxml.jackson.annotation.JsonView;
import imie.java.tp.model.Identifiable;
import imie.java.tp.model.Views;

import java.util.List;

public class ServerTO implements Identifiable<Integer> {

    private Integer id;

    private Long memorySize;

    private Long diskSize;

    private String name;

    private List<MonitoringTO> monitorings;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(Views.Public.class)
    public Long getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(Long memorySize) {
        this.memorySize = memorySize;
    }

    @JsonView(Views.Public.class)
    public Long getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Long diskSize) {
        this.diskSize = diskSize;
    }

    @JsonView(Views.Public.class)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonView(Views.Server.class)
    public List<MonitoringTO> getMonitorings() {
        return monitorings;
    }

    public void setMonitorings(List<MonitoringTO> monitorings) {
        this.monitorings = monitorings;
    }

}

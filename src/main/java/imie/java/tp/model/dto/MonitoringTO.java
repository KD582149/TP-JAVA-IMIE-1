package imie.java.tp.model.dto;

import com.fasterxml.jackson.annotation.JsonView;
import imie.java.tp.model.Identifiable;
import imie.java.tp.model.Views;

import java.util.List;

public class MonitoringTO implements Identifiable<Integer> {

    private Integer id;

    private String time;

    private Integer trafficIn;

    private Integer trafficOut;

    private Long memoryUsed;

    private Integer securityError;

    private List<Double> cpus;

    private Long diskUsed;

    private ServerTO server;

    @JsonView(Views.Public.class)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @JsonView(Views.Public.class)
    public Integer getTrafficIn() {
        return trafficIn;
    }

    public void setTrafficIn(Integer trafficIn) {
        this.trafficIn = trafficIn;
    }

    @JsonView(Views.Public.class)
    public Integer getTrafficOut() {
        return trafficOut;
    }

    public void setTrafficOut(Integer trafficOut) {
        this.trafficOut = trafficOut;
    }

    @JsonView(Views.Public.class)
    public Long getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(Long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    @JsonView(Views.Public.class)
    public Integer getSecurityError() {
        return securityError;
    }

    public void setSecurityError(Integer securityError) {
        this.securityError = securityError;
    }

    @JsonView(Views.Public.class)
    public List<Double> getCpus() {
        return cpus;
    }

    public void setCpus(List<Double> cpus) {
        this.cpus = cpus;
    }

    @JsonView(Views.Public.class)
    public Long getDiskUsed() {
        return diskUsed;
    }

    public void setDiskUsed(Long diskUsed) {
        this.diskUsed = diskUsed;
    }

    @JsonView(Views.Monitoring.class)
    public ServerTO getServer() {
        return server;
    }

    public void setServer(ServerTO server) {
        this.server = server;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}

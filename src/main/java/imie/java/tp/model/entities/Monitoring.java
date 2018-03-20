package imie.java.tp.model.entities;

import imie.java.tp.model.Identifiable;

import javax.persistence.*;

@Entity
@Table(name = "server_monitoring")
public class Monitoring implements Identifiable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "monitoring_id")
    private Integer id;

    @Column(name = "time", nullable = false)
    private Long time;

    @Column(name ="traffic_in", nullable = false)
    private Integer trafficIn;

    @Column(name = "traffic_out", nullable = false)
    private Integer trafficOut;

    @Column(name = "memory_used", nullable = false)
    private Long memoryUsed;

    @Column(name = "security_error", nullable = false)
    private Integer securityError;

    @Column(name = "cpu0", nullable = false)
    private Double cpu0;

    @Column(name = "cpu1", nullable = false)
    private Double cpu1;

    @Column(name = "cpu2", nullable = false)
    private Double cpu2;

    @Column(name = "cpu3", nullable = false)
    private Double cpu3;

    @Column(name = "cpu4", nullable = false)
    private Double cpu4;

    @Column(name = "cpu5", nullable = false)
    private Double cpu5;

    @Column(name = "cpu6", nullable = false)
    private Double cpu6;

    @Column(name = "cpu7", nullable = false)
    private Double cpu7;

    @Column(name = "cpu8", nullable = false)
    private Double cpu8;

    @Column(name = "disk_used", nullable = false)
    private Long diskUsed;

    @ManyToOne
    @JoinColumn(name = "server_ref")
    private Server server;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getTrafficIn() {
        return trafficIn;
    }

    public void setTrafficIn(Integer trafficIn) {
        this.trafficIn = trafficIn;
    }

    public Integer getTrafficOut() {
        return trafficOut;
    }

    public void setTrafficOut(Integer trafficOut) {
        this.trafficOut = trafficOut;
    }

    public Long getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(Long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public Integer getSecurityError() {
        return securityError;
    }

    public void setSecurityError(Integer securityError) {
        this.securityError = securityError;
    }

    public Double getCpu0() {
        return cpu0;
    }

    public void setCpu0(Double cpu0) {
        this.cpu0 = cpu0;
    }

    public Double getCpu1() {
        return cpu1;
    }

    public void setCpu1(Double cpu1) {
        this.cpu1 = cpu1;
    }

    public Double getCpu2() {
        return cpu2;
    }

    public void setCpu2(Double cpu2) {
        this.cpu2 = cpu2;
    }

    public Double getCpu3() {
        return cpu3;
    }

    public void setCpu3(Double cpu3) {
        this.cpu3 = cpu3;
    }

    public Double getCpu4() {
        return cpu4;
    }

    public void setCpu4(Double cpu4) {
        this.cpu4 = cpu4;
    }

    public Double getCpu5() {
        return cpu5;
    }

    public void setCpu5(Double cpu5) {
        this.cpu5 = cpu5;
    }

    public Double getCpu6() {
        return cpu6;
    }

    public void setCpu6(Double cpu6) {
        this.cpu6 = cpu6;
    }

    public Double getCpu7() {
        return cpu7;
    }

    public void setCpu7(Double cpu7) {
        this.cpu7 = cpu7;
    }

    public Double getCpu8() {
        return cpu8;
    }

    public void setCpu8(Double cpu8) {
        this.cpu8 = cpu8;
    }

    public Long getDiskUsed() {
        return diskUsed;
    }

    public void setDiskUsed(Long diskUsed) {
        this.diskUsed = diskUsed;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
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

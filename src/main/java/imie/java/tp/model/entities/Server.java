package imie.java.tp.model.entities;

import imie.java.tp.model.Identifiable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "server")
public class Server implements Identifiable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "server_id")
    private Integer id;

    @Column(name = "memory_size", nullable = false)
    private Long memorySize;

    @Column(name = "disk_size", nullable = false)
    private Long diskSize;

    @Column(name = "server_name", length = 100, nullable = false)
    private String name;

    @OneToMany (mappedBy = "server")
    private List<Monitoring> monitorings;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(Long memorySize) {
        this.memorySize = memorySize;
    }

    public Long getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Long diskSize) {
        this.diskSize = diskSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Monitoring> getMonitorings() {
        return monitorings;
    }

    public void setMonitorings(List<Monitoring> monitorings) {
        this.monitorings = monitorings;
    }
}

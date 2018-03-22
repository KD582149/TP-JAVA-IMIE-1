package imie.java.tp.model.entities;

import imie.java.tp.model.Identifiable;

import javax.persistence.*;

@Entity
@Table(name = "chart")
public class Chart implements Identifiable<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "chart_id")
    private Integer id;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ChartType type;

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "abs_name", nullable = false)
    private String absName;

    @Column(name = "ord_name", nullable = false)
    private String ordName;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public ChartType getType() {
        return type;
    }

    public void setType(ChartType type) {
        this.type = type;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAbsName() {
        return absName;
    }

    public void setAbsName(String absName) {
        this.absName = absName;
    }

    public String getOrdName() {
        return ordName;
    }

    public void setOrdName(String ordName) {
        this.ordName = ordName;
    }
}

package imie.java.tp.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ChartRequest {

    @NotNull @Length(min = 1)
    private String server;

    private List<String> series;

    public ChartRequest() {
        series = new ArrayList<>();
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public List<String> getSeries() {
        return series;
    }

    public void setSeries(List<String> series) {
        this.series = series;
    }
}

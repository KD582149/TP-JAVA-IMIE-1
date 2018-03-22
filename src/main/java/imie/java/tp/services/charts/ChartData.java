package imie.java.tp.services.charts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChartData {

    private String name;
    private List<Number> absValues;
    private Map<String, Map<Number, Number>> series;

    public ChartData() {
        absValues = new ArrayList<>();
        series = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Number> getAbsValues() {
        return absValues;
    }

    public void setAbsValues(List<Number> absValues) {
        this.absValues = absValues;
    }

    public Map<String, Map<Number, Number>> getSeries() {
        return series;
    }

    public void setSeries(Map<String, Map<Number, Number>> series) {
        this.series = series;
    }
}

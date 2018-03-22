package imie.java.tp.services.charts.configurations;

import imie.java.tp.model.entities.ChartType;
import imie.java.tp.services.charts.ChartData;
import imie.java.tp.services.charts.processors.ChartProcessor;
import imie.java.tp.services.charts.processors.LineChartProcessor;

import java.util.HashMap;
import java.util.Map;

public class ChartConfigurator<T> {
    private String name;
    private ChartType chartType;
    private ChartConfiguration.NumeralPropertyAccessor<T> abscissaAccessor;
    private Map<String, ChartConfiguration.NumeralPropertyAccessor<T>> seriesAccessors;

    private ChartConfigurator() {
        this.seriesAccessors = new HashMap<>();
    }

    public static <T> ChartConfigurator<T> newConfigurator(
            final Class<? extends T> dataType) {
        return new ChartConfigurator<>();
    }

    public ChartConfigurator<T> name(String name) {
        this.name = name;
        return this;
    }

    public ChartConfigurator<T> chartType(ChartType chartType) {
        this.chartType = chartType;
        return this;
    }

    public ChartConfigurator<T> abscissa(ChartConfiguration.NumeralPropertyAccessor<T> accessor) {
        this.abscissaAccessor = accessor;
        return this;
    }

    public ChartConfigurator<T> serie(String name,
                                      ChartConfiguration.NumeralPropertyAccessor<T> accessor) {
        seriesAccessors.put(name, accessor);
        return this;
    }

    public ChartConfiguration<T> build() {
        if (chartType == null || name == null || name.trim().isEmpty() ||
                abscissaAccessor == null || seriesAccessors.isEmpty()) {
            throw new IllegalStateException("Some of the following required settings are missings : " +
                    "name, abscissa accessor, at least one serie accessor.");
        }

        return new ChartConfiguration<T>() {
            @Override public String getName() { return name; }
            @Override public ChartType getChartType() { return chartType; }
            @Override public NumeralPropertyAccessor<T> getAbscissaAccessor() { return abscissaAccessor; }
            @Override public Map<String, NumeralPropertyAccessor<T>> getSeriesAccessors() { return seriesAccessors; }

            @Override public ChartProcessor<T> getProcessor() {
                switch (chartType) {
                    case LINE_CHART:
                        return new LineChartProcessor<>(this);
                    default :
                        // Null processor
                        return (data) -> new ChartData();
                }
            }
        };
    }
}

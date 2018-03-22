package imie.java.tp.services.charts.configurations;

import imie.java.tp.model.entities.ChartType;
import imie.java.tp.services.charts.processors.ChartProcessor;

import java.util.Map;
import java.util.function.Function;

public interface ChartConfiguration<T> {
    interface NumeralPropertyAccessor<T> extends Function<T, Number> {}

    String getName();
    ChartType getChartType();

    NumeralPropertyAccessor<T> getAbscissaAccessor();
    Map<String, NumeralPropertyAccessor<T>> getSeriesAccessors();

    ChartProcessor<T> getProcessor();
}

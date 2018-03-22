package imie.java.tp.services.charts.processors;

import imie.java.tp.services.charts.ChartData;

@FunctionalInterface
public interface ChartProcessor<T> {
    ChartData process(Iterable<T> data);
}

package imie.java.tp.services.charts.adapters;

import imie.java.tp.services.charts.ChartData;

public interface ChartDataAdapter<T> {
    T adapt(ChartData genericData);
}

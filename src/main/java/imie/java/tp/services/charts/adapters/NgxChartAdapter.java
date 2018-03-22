package imie.java.tp.services.charts.adapters;

import imie.java.tp.services.charts.ChartData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NgxChartAdapter implements ChartDataAdapter<NgxChartData> {
    @Override
    public NgxChartData adapt(ChartData genericData) {
        NgxChartData target = new NgxChartData();
        for (Map.Entry<String, Map<Number, Number>> entry :
                genericData.getSeries().entrySet())
        {
            String serieName = entry.getKey();
            List<NgxChartData.PointValue> serieValues = entry.getValue().entrySet()
                    .stream()
                    .map(serieValue ->
                            new NgxChartData.PointValue(serieValue.getKey(), serieValue.getValue()))
                    .collect(Collectors.toList());

            target.add(new NgxChartData.Serie(serieName, serieValues));
        }
        return target;
    }
}

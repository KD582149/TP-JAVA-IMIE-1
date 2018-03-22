package imie.java.tp.services.charts.adapters;

import java.util.ArrayList;
import java.util.List;

public class NgxChartData extends ArrayList<NgxChartData.Serie> {
    static class PointValue {
        public Number name;
        public Number value;

        public PointValue(Number name, Number value) {
            this.name = name;
            this.value = value;
        }
    }

    public static class Serie {
        public String name;
        public List<PointValue> series;

        public Serie(String name, List<PointValue> series) {
            this.name = name;
            this.series = series;
        }
    }

}

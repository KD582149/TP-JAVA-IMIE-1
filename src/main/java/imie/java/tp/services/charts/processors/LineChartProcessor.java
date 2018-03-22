package imie.java.tp.services.charts.processors;

import imie.java.tp.services.charts.ChartData;
import imie.java.tp.services.charts.configurations.ChartConfiguration;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class LineChartProcessor<T> implements ChartProcessor<T> {

    private final ChartConfiguration<T> configuration;

    public LineChartProcessor(ChartConfiguration<T> configuration) {
        this.configuration = configuration;
    }

    @Override
    public ChartData process(Iterable<T> data) {
        ChartData result = new ChartData();

        // Récupération des valeurs d'abscisse à partir des données entrantes
        result.setAbsValues(
                StreamSupport.stream(data.spliterator(), false)
                        .map(configuration.getAbscissaAccessor())
                        .collect(Collectors.toList()));

        // Pour chaque série
        configuration.getSeriesAccessors().keySet()
                .forEach(serieName -> {
                    // Instanciation des map de correspondances abscisses/ordonnées
                    result.getSeries().put(serieName, new HashMap<>());

                    // Pour chaque entrée de données
                    for (T d : data) {
                        // Ajout de la paire abscisse/ordonnée (correspondante à la série)
                        result.getSeries().get(serieName).put(
                                configuration.getAbscissaAccessor().apply(d),
                                configuration.getSeriesAccessors().get(serieName).apply(d));
                    }
                });

        return result;
    }
}

package imie.java.tp.controllers;

import imie.java.tp.errors.BadRequestException;
import imie.java.tp.errors.NotFoundException;
import imie.java.tp.model.ChartRequest;
import imie.java.tp.model.CsvMemoryModel;
import org.gridmodel.core.model.Row;
import org.gridmodel.query.results.ResultStore;
import org.gridmodel.query.results.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imie.java.tp.utils.GeneralUtils.isEmpty;
import static imie.java.tp.utils.GeneralUtils.valueOrDefault;
import static org.gridmodel.query.criteria.CriterionFactory.equalTo;

@RestController
@RequestMapping("/api/charts")
public class ChartController {

    private final CsvMemoryModel model;

    @Autowired
    public ChartController(CsvMemoryModel model) {
        this.model = model;
    }

    /**
     * Renvoie les informations du serveur demandé
     * * Version requête JSON
     * @param req La requête cliente
     * @return Les informations brutes pour exploitation par la librairie de graphiques
     */
    @PostMapping
    public List<List<Number>> getServerInfo(
        @RequestBody @Valid ChartRequest req)
    {
        return getServerInfo(req.getServer(), req.getSeries());
    }

    /**
     * Renvoie les informations du serveur demandé
     * * Version Query Strings
     * @param server Le nom du serveur
     * @param seriesList La liste des séries (colonnes) à afficher
     * @return Les informations brutes pour exploitation par la librairie de graphiques
     */
    @GetMapping
    public List<List<Number>> getServerInfo(
        @RequestParam(value = "server") String server,
        @RequestParam(value = "series", required = false) List<String> seriesList
    ) {
        List<String> series = new ArrayList<>(
                valueOrDefault(seriesList, model.getSeries()));

        if (!series.contains("time"))
            series.add(0, "time");

        if (isEmpty(server))
            throw new BadRequestException("You must specify a server");

        if (!model.getServers().contains(server))
            throw new NotFoundException("The server %s is unknown from the server.");

        ResultStore rs = model.getBaseInstance()
                .query(series)
                .where("server", equalTo(server))
                .fetch();

        return rs.transform(new ChartDataTransformer(series));
    }

    /**
     * Classe transformant chaque enregistrement retourné par GridModel en
     * tableau de données brutes JSON.
     */
    private class ChartDataTransformer implements ResultTransformer<List<Number>> {

        private List<String> series;

        public ChartDataTransformer(List<String> series) {
            this.series = series;
        }

        @Override
        public List<Number> apply(Row row) {
            return series.stream()
                    .map(serie -> row.containsKey(serie) ?
                            parseNumber(row.get(serie)) : null)
                    .collect(Collectors.toList());
        }

        private Number parseNumber(Object o) {
            try {
                return Double.parseDouble(o.toString());
            } catch (NumberFormatException ex) {
                return null;
            }
        }
    }

}

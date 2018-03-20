package imie.java.tp.services;

import imie.java.tp.errors.NotFoundException;
import imie.java.tp.model.entities.Monitoring;
import imie.java.tp.model.entities.Server;
import imie.java.tp.repositories.MonitoringRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static imie.java.tp.utils.GeneralUtils.fromIterable;
import static imie.java.tp.utils.GeneralUtils.isEmpty;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

@Service
public class MonitoringService {

    private final MonitoringRepository repository;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public MonitoringService(MonitoringRepository repository) {
        this.repository = repository;
    }

    public List<Monitoring> findAll() {
        return fromIterable(repository.findAll(), ArrayList::new);
    }

    public Monitoring find(Integer id) throws NotFoundException {
        if (!repository.exists(id)) {
            throw new NotFoundException(id, Server.class);
        }
        return repository.findOne(id);
    }

    public List<Monitoring> findAll(String rawBefore, String rawAfter) {
        if (isEmpty(rawBefore) && isEmpty(rawAfter))
            return findAll();

        LocalDateTime afterDate = parseDateTime(rawAfter, LocalDateTime.MIN);
        LocalDateTime beforeDate = parseDateTime(rawBefore, LocalDateTime.MAX);

        long after = afterDate.toInstant(ZoneOffset.UTC).getEpochSecond();
        long before = beforeDate.toInstant(ZoneOffset.UTC).getEpochSecond();

        return repository.searchByDateInterval(before, after);
    }

    private LocalDateTime parseDateTime(String dateString, LocalDateTime defaultValue) {
        try {
            return dateString == null || dateString.trim().isEmpty() ?
                    defaultValue : LocalDateTime.parse(dateString, ISO_DATE_TIME);
        } catch (DateTimeParseException ex) {
            logger.warn("La date {} utilisée pour la recherche n'est pas correcte et sera remplacé par une valeur par défaut.", dateString);
            ex.printStackTrace();
            return defaultValue;
        }
    }

}

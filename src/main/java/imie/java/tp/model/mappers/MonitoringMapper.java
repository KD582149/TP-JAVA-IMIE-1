package imie.java.tp.model.mappers;

import imie.java.tp.model.dto.MonitoringTO;
import imie.java.tp.model.entities.Monitoring;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonitoringMapper implements Mapper<Monitoring, MonitoringTO> {

    final ServerMapper serverMapper = new ServerMapper(true);

    private List<Double> aggregateCpus(Monitoring source) {
        return Stream.of(
                source.getCpu0(), source.getCpu1(), source.getCpu2(), source.getCpu3(), source.getCpu4(),
                source.getCpu5(), source.getCpu6(), source.getCpu7(), source.getCpu8())
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    private String convertTime(long time) {
        return Instant.ofEpochSecond(time).toString();
    }

    @Override
    public MonitoringTO map(Monitoring source) {
        MonitoringTO target = new MonitoringTO();
        target.setId(source.getId());
        target.setDiskUsed(source.getDiskUsed());
        target.setMemoryUsed(source.getMemoryUsed());
        target.setSecurityError(source.getSecurityError());
        target.setTrafficIn(source.getTrafficIn());
        target.setTrafficOut(source.getTrafficOut());

        target.setTime(convertTime(source.getTime()));
        target.setCpus(aggregateCpus(source));
        target.setServer(serverMapper.map(source.getServer()));
        return target;
    }

    @Override
    public Monitoring reverse(MonitoringTO target) {
        // TODO Pas encore implémenté
        return null;
    }
}

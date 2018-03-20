package imie.java.tp.model.mappers;

import imie.java.tp.model.dto.ServerTO;
import imie.java.tp.model.entities.Server;

import java.util.ArrayList;

public class ServerMapper implements Mapper<Server, ServerTO> {
    private boolean ignoreMonitorings = false;
    private MonitoringMapper nestedMonitoringMapper = null;

    public ServerMapper() {
        this(false);
    }

    public ServerMapper(boolean ignoreMonitorings) {
        this.ignoreMonitorings = ignoreMonitorings;
        if (!ignoreMonitorings) {
            nestedMonitoringMapper = new MonitoringMapper();
        }
    }

    @Override
    public ServerTO map(Server source) {
        ServerTO target = new ServerTO();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDiskSize(source.getDiskSize());
        target.setMemorySize(source.getMemorySize());

        if (!ignoreMonitorings) {
            target.setMonitorings(
                    nestedMonitoringMapper.map(source.getMonitorings(), ArrayList::new));
        }
        return target;
    }

    @Override
    public Server reverse(ServerTO target) {
        // TODO Pas encore implémenté
        return null;
    }
}

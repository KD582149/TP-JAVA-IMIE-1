package imie.java.tp.repositories;

import imie.java.tp.model.ServerMonitoring;
import org.springframework.data.repository.CrudRepository;

public interface MonitoringRepository extends CrudRepository <ServerMonitoring, Integer> {
}

package imie.java.tp.repositories;

import imie.java.tp.model.entities.Monitoring;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MonitoringRepository extends CrudRepository <Monitoring, Integer> {

    @Query("select m from Monitoring m where m.time between :after and :before")
    List<Monitoring> searchByDateInterval(@Param("before") Long before,
                                          @Param("after")  Long after);
}

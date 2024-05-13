package edu.pja.mas.gonul.masfinal.Repositories;

import edu.pja.mas.gonul.masfinal.Model.Maintenance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MaintenanceRepository extends CrudRepository<Maintenance,Long> {
    List<Maintenance> findByAircraftAircraftId(Long aircraftId);

}

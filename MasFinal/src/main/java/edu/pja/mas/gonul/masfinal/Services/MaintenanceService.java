package edu.pja.mas.gonul.masfinal.Services;

import edu.pja.mas.gonul.masfinal.Model.Maintenance;
import edu.pja.mas.gonul.masfinal.Repositories.AircraftRepository;
import edu.pja.mas.gonul.masfinal.Repositories.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {


    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceService(MaintenanceRepository maintenanceRepository, AircraftRepository aircraftRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public List<Maintenance> getMaintenanceByAircraftId(Long aircraftId) {
        return maintenanceRepository.findByAircraftAircraftId(aircraftId);
    }


}

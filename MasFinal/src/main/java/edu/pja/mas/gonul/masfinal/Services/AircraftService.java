package edu.pja.mas.gonul.masfinal.Services;

import edu.pja.mas.gonul.masfinal.Model.Aircraft;
import edu.pja.mas.gonul.masfinal.Repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {


    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAllAircrafts() {
        return (List<Aircraft>) aircraftRepository.findAll();
    }


    public void saveAircraft(Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(Long aircraftId) {
        aircraftRepository.deleteById(aircraftId);
    }


}

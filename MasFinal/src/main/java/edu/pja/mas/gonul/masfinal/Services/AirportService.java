package edu.pja.mas.gonul.masfinal.Services;

import edu.pja.mas.gonul.masfinal.Model.Airport;
import edu.pja.mas.gonul.masfinal.Repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {


    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }


    public List<Airport> getAllAirports() {
        return (List<Airport>) airportRepository.findAll();
    }

    public List<Airport> findAirportsByLocation(String location) {
        List<Airport> result = new ArrayList<>();
        for (Airport airport : airportRepository.findAll()) {
            if (airport.getLocation().equalsIgnoreCase(location)) {
                result.add(airport);
            }
        }
        return result;
    }
}

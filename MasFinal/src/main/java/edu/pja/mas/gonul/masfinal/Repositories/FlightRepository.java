package edu.pja.mas.gonul.masfinal.Repositories;

import edu.pja.mas.gonul.masfinal.Model.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface FlightRepository extends CrudRepository<Flight,Long> {
}

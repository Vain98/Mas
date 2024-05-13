package edu.pja.mas.gonul.masfinal.Repositories;

import edu.pja.mas.gonul.masfinal.Model.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    List<Ticket> findByPassengerPassengerId(Long passengerId);

    List<Ticket> findByFlightFlightId(Long flightId);
}

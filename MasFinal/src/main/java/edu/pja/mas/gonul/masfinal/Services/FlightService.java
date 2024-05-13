package edu.pja.mas.gonul.masfinal.Services;

import edu.pja.mas.gonul.masfinal.Model.Flight;
import edu.pja.mas.gonul.masfinal.Model.Ticket;
import edu.pja.mas.gonul.masfinal.Repositories.FlightRepository;
import edu.pja.mas.gonul.masfinal.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, TicketRepository ticketRepository) {
        this.flightRepository = flightRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<Flight> getAllFlights() {
        return (List<Flight>) flightRepository.findAll();
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Transactional
    public void deleteFlight(Long flightId) {
        List<Ticket> tickets = ticketRepository.findByFlightFlightId(flightId);

        for (Ticket ticket : tickets) {
            ticketRepository.delete(ticket);

        }

        flightRepository.deleteById(flightId);
    }
    public long countFlightsDepartingFromAirport(String airportCode) {
        int count = 0;
        for (Flight flight : flightRepository.findAll()) {
            if (flight.getOrigin() != null && flight.getOrigin().equals(airportCode)) {
                count++;
            }
        }
        return count;
    }
}




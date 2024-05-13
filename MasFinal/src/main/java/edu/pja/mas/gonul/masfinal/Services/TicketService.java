package edu.pja.mas.gonul.masfinal.Services;

import edu.pja.mas.gonul.masfinal.Model.Passenger;
import edu.pja.mas.gonul.masfinal.Model.Ticket;
import edu.pja.mas.gonul.masfinal.Repositories.PassengerRepository;
import edu.pja.mas.gonul.masfinal.Repositories.TicketRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final PassengerRepository passengerRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, PassengerRepository passengerRepository) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
    }


    public List<Ticket> listAllTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    public List<Ticket> getTicketsByPassengerId(Long passengerId) {
        return ticketRepository.findByPassengerPassengerId(passengerId);
    }

    public List<Passenger> listAllPassengers() {
        return (List<Passenger>) passengerRepository.findAll();
    }

    public Ticket changeSeatNumber(Long ticket_number,String newSeatNumber){
        Ticket ticket=ticketRepository.findById(ticket_number).orElseThrow(()->new EntityNotFoundException("Ticket not found by id"+ticket_number));
        ticket.setSeatNumber(newSeatNumber);
        return ticketRepository.save(ticket);
    }
    public List<Ticket> findTicketsPricedAbove200() {
        int priceThreshold = 200;
        List<Ticket> result = new ArrayList<>();
        for (Ticket ticket : ticketRepository.findAll()) {
            if (ticket.getPrice() > priceThreshold) {
                result.add(ticket);
            }
        }
        return result;
    }
}

package edu.pja.mas.gonul.masfinal.Services;

import edu.pja.mas.gonul.masfinal.Model.Passenger;
import edu.pja.mas.gonul.masfinal.Model.Ticket;
import edu.pja.mas.gonul.masfinal.Repositories.PassengerRepository;
import edu.pja.mas.gonul.masfinal.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    private final TicketRepository ticketRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository, TicketRepository ticketRepository) {
        this.passengerRepository = passengerRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<Passenger> listAllPassengers() {
        return (List<Passenger>) passengerRepository.findAll();
    }

    public void savePassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    @Transactional
    public void deletePassenger(Long passengerId) {
        List<Ticket> tickets = ticketRepository.findByPassengerPassengerId(passengerId);

        for (Ticket ticket : tickets) {
            ticketRepository.delete(ticket);
        }

        passengerRepository.deleteById(passengerId);
    }
    public List<Passenger> findPassengersWithSpecialNeeds() {
        List<Passenger> result = new ArrayList<>();
        for (Passenger passenger : passengerRepository.findAll()) {
            if (passenger.isSpeacialneeds()) {
                result.add(passenger);
            }
        }
        return result;
    }


}

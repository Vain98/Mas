import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Passenger {

    private String name;
    private String surname;
    private String ticketNumber;
    private Flight flight;
    private Set<Ticket> tickets = new HashSet<>();

    public Passenger(String name, String surname, String ticketNumber) {
        this.name = name;
        this.surname = surname;
        this.ticketNumber = ticketNumber;
        this.flight = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        if (this.flight != null && this.ticketNumber != null) {
            this.flight.removePassenger(this);
        }
        this.ticketNumber = ticketNumber;
        if (this.flight != null && this.ticketNumber != null) {
            this.flight.addPassenger(this);
        }
    }

    public Set<Ticket> getTickets() {
        return Collections.unmodifiableSet(tickets);
    }

    public void addTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null.");
        }
        if (!ticket.getPassenger().equals(this)) {
            throw new IllegalArgumentException("Ticket is not associated with this passenger.");
        }
        this.tickets.add(ticket);
    }
    public void removeTicket(Ticket ticket) {
        if (ticket != null && this.tickets.contains(ticket)) {
            this.tickets.remove(ticket);
            ticket.invalidate(); //reverse connection
        }
    }


    public void setFlight(Flight flight) {
        if (this.flight != null && !this.flight.equals(flight)) {
            this.flight.removePassenger(this); //remove this passenger from old flight
        }
        this.flight = flight; //assign new flight

    }

    //remove composition
    public void remove(){
        this.tickets.forEach(this::removeTicket);
    }

}



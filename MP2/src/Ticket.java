public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private String seatNumber;

    private Ticket(Passenger passenger, String seatNumber, Flight flight) {
        this.passenger = passenger;
        this.seatNumber = seatNumber;
        this.flight = flight;
    }

    public static Ticket createTicket(Passenger passenger, String seatNumber, Flight flight) throws Exception {
        if(passenger == null) {
            throw new Exception("The passenger does not exist");
        }
        // Create a new part
        Ticket ticket = new Ticket(passenger, seatNumber,flight);
        // Add to the whole
        passenger.addTicket(ticket);
        return ticket;

    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void invalidate() {
         flight.removeTicket(this);
         passenger.removeTicket(this); //reverse connection
    }

}

import java.util.*;


public class Flight {
    private String flightNumber;
    private AirCraft airCraft;
    private Set<Crew> crewMembers;
    private Airport destinationAirport;
    private Airport departureAirport;
    private List<Passenger> passengers; //binary
    private List<Ticket> tickets = new ArrayList<>(); //binary
    private Set<FlightAssignment> flightAssignments; //with attribute
    private Map<String, Passenger> passengersByTicketNumber; //qualified

    public Flight(String flightNumber, AirCraft airCraft,
                  Airport destinationAirport, Airport departureAirport, Passenger passenger) {
        setFlightNumber(flightNumber);
        setAirCraft(airCraft);
        setDestinationAirport(destinationAirport);
        setDepartureAirport(departureAirport);
        this.passengers = new ArrayList<>();
        this.passengers.add(passenger);
        this.flightAssignments = new HashSet<>();
        passengersByTicketNumber = new HashMap<>();
    }


    public void setFlightAssignments(Set<FlightAssignment> flightAssignments) {
        this.flightAssignments = flightAssignments;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        if(flightNumber== null || !flightNumber.matches("[A-Z]{2}\\d{4}")){
            throw new IllegalArgumentException("Invalid Format");
        }
        this.flightNumber=flightNumber;
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(AirCraft airCraft) {
//        if (this.airCraft != airCraft){
//            this.airCraft = airCraft;
//        }  //else do nothing

        this.airCraft = airCraft;

        airCraft.addFlight(this); //reverse connection

    }

    public Set<Crew> getCrewMembers() {
        return Collections.unmodifiableSet(crewMembers);
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        if (destinationAirport == null) {
            throw new IllegalArgumentException("Destination airport can not be null.");
        }
        if (destinationAirport.equals(this.departureAirport)) {
            throw new IllegalArgumentException("Destination and departure can not be the same.");
        }
        this.destinationAirport = destinationAirport;
    }


    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        if (departureAirport == null) {
            throw new IllegalArgumentException("Departure airport can not be null.");
        }
        if (departureAirport.equals(this.destinationAirport)) {
            throw new IllegalArgumentException("Departure and destination can not be the same");
        }
        this.departureAirport = departureAirport;
    }


    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public void setPassengers(List<Passenger> passengers) {
        if(passengers==null || passengers.isEmpty()){
            throw new IllegalArgumentException("Passengers can not be null");
        }
        this.passengers=passengers;
    }
    public void setCrewMembers(Map<Crew, String> crewMembersWithRoles) {
        if (crewMembersWithRoles == null || crewMembersWithRoles.isEmpty()) {
            throw new IllegalArgumentException("Crew members with roles cannot be null or empty.");
        }
        this.crewMembers.clear();
        this.flightAssignments.clear();

        for (Map.Entry<Crew, String> entry : crewMembersWithRoles.entrySet()) {
            addCrewMember(entry.getKey(), entry.getValue());
        }
    }

    public void addCrewMember(Crew crew, String role) {
        if (crew == null) {
            throw new IllegalArgumentException("Crew member cannot be null.");
        }
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty.");
        }

        this.crewMembers.add(crew);
        FlightAssignment assignment = new FlightAssignment(crew, this, role);

        this.flightAssignments.add(assignment);
        crew.addFlightAssignment(assignment);
    }

    public void addPassenger(Passenger passenger) {
        if (passenger == null || passenger.getTicketNumber() == null) {
            throw new IllegalArgumentException("Passenger or ticket number cannot be null.");
        }
        passengers.add(passenger);
        passengersByTicketNumber.put(passenger.getTicketNumber(), passenger);
        passenger.setFlight(this); //
    }

    public void removePassenger(Passenger passenger) {
        if (passenger != null && passengersByTicketNumber.containsKey(passenger.getTicketNumber())) {
            passengers.remove(passenger);
            passengersByTicketNumber.remove(passenger.getTicketNumber());
            passenger.setFlight(null);
        }
    }
    public void addTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null.");
        }
        if (!ticket.getFlight().equals(this)) {
            throw new IllegalArgumentException("Ticket is not associated with this flight.");
        }
        this.tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        if (ticket != null && this.tickets.contains(ticket)) {
            this.tickets.remove(ticket);
            ticket.invalidate();
        }
    }
    public void addFlightAssignment(FlightAssignment flightAssignment) {
        if (flightAssignment == null) {
            throw new IllegalArgumentException("Flight assignment cannot be null.");
        }
        if (!flightAssignment.getFlight().equals(this)) {
            throw new IllegalArgumentException("Flight assignment does not match this flight.");
        }
        this.flightAssignments.add(flightAssignment);
    }

    public void removeFlightAssignment(FlightAssignment flightAssignment) {
        if (flightAssignment != null) {
            this.flightAssignments.remove(flightAssignment);
        }
    }

    public Set<FlightAssignment> getFlightAssignments() {
        return Collections.unmodifiableSet(flightAssignments);
    }
    public Passenger getPassengerByTicketNumber(String ticketNumber) {
        return passengersByTicketNumber.get(ticketNumber);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", airCraft=" + airCraft +
                ", destinationAirport=" + destinationAirport +
                ", departureAirport=" + departureAirport +
                '}';
    }
}


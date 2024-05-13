public class FlightAssignment { //attribute between crew and flight as many-to-many association
    private Crew crew;
    private Flight flight;
    private String role;

    public FlightAssignment(Crew crew, Flight flight, String role) {
        this.crew = crew;
        this.flight = flight;
        this.role = role;
        crew.addFlightAssignment(this);
        flight.addFlightAssignment(this);
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "FlightAssignment{" +
                "crew=" + crew +
                ", flight=" + flight +
                ", role='" + role + '\'' +
                '}';
    }
}

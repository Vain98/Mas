import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AirCraft {

    private String registrationNumber;
    private Set<Flight> assignedFlights = new HashSet<>();

    public AirCraft(String registrationNumber) {
        setRegistrationNumber(registrationNumber);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber != null){
            this.registrationNumber = registrationNumber;
        } else throw new IllegalArgumentException("Registration num cannot be null");

    }

    public Set<Flight> getAssignedFlights() {
        return Collections.unmodifiableSet(assignedFlights);
    }

    public void addFlight(Flight flight) {
        if (flight == null) {
            throw new IllegalArgumentException("Ticket cannot be null.");
        }
        this.assignedFlights.add(flight);
    }
    public void removeFlight(Flight flight) {
        if (flight != null) {
            this.assignedFlights.remove(flight);
            //reverse connection
        }
    }
}

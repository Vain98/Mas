import java.util.HashSet;
import java.util.Set;

public class FlightManager {

    private Set<Flights> assignedFlights = new HashSet<>();//subset
    private Set<Flights> priorityFlights = new HashSet<>();//subset

    private Set<String> flightIds = new HashSet<>();

    public boolean addFlight(Flights flights) {
        if (!flightIds.contains(flights.getFlightsID())) {
            flightIds.add(flights.getFlightsID());
            return true;
        }
        return false;
    }

    public void assignFlight(Flights flights) {
        assignedFlights.add(flights);
    }

    public void addPriorityFlight(Flights flights) {
        if (assignedFlights.contains(flights)) {
            priorityFlights.add(flights);
        } else {
            throw new IllegalStateException("Flight must be assigned before it can be a priority flight.");
        }
    }

    public boolean isPriorityFlight(Flights flights) {
        return priorityFlights.contains(flights);

    }

    public Set<Flights> getAssignedFlights() {
        return assignedFlights;
    }

    public void setAssignedFlights(Set<Flights> assignedFlights) {
        this.assignedFlights = assignedFlights;
    }

    public Set<Flights> getPriorityFlights() {
        return priorityFlights;
    }

    public void setPriorityFlights(Set<Flights> priorityFlights) {
        this.priorityFlights = priorityFlights;
    }

    public Set<String> getFlightIds() {
        return flightIds;
    }

    public void setFlightIds(Set<String> flightIds) {
        this.flightIds = flightIds;
    }
}

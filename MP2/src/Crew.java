import java.util.*;
public class Crew {
    private String id;
    private String name;
    private Set<FlightAssignment> flightAssignments;


    public Crew(String id, String name, Flight assignedFlight) {
        this.id = id;
        this.name = name;
        this.flightAssignments = new HashSet<>();
        this.flightAssignments.add(new FlightAssignment(this, assignedFlight, "crew"));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<FlightAssignment> getFlightAssignments() {
        return flightAssignments;
    }

    public void setFlightAssignments(Set<FlightAssignment> flightAssignments) {
        this.flightAssignments = flightAssignments;
    }

    public void addFlightAssignment(FlightAssignment flightAssignment) {
        if (flightAssignment == null) {
            throw new IllegalArgumentException("Flight assignment can not be null.");
        }
        if (!flightAssignment.getCrew().equals(this)) {
            throw new IllegalArgumentException("Flight assignment does not match this crew.");
        }
        this.flightAssignments.add(flightAssignment);
    }


    public void removeFlightAssignment(FlightAssignment flightAssignment) {
        if (flightAssignment != null && this.flightAssignments.contains(flightAssignment)){
            this.flightAssignments.remove(flightAssignment);
        } else throw new IllegalArgumentException("Not valid flight assignment");

    }

    @Override
    public String toString() {
        return "Crew{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

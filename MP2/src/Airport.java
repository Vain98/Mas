import java.util.*;
public class Airport {

    private String airportCode;
    private Set<Flight> arrivals;
    private Set<Flight> departures;
    private Map<String, Flight> flightsByNumber = new HashMap<>();

    public Airport(String airportCode) {
        this.airportCode = airportCode;
        this.arrivals = new HashSet<>();
        this.departures = new HashSet<>();
        this.flightsByNumber = new HashMap<>();
    }


    public Set<Flight> getArrivals() {
        return arrivals;
    }

    public Set<Flight> getDepartures() {
        return departures;
    }

    public String getAirportCode() {
        return airportCode;
    }

    // Setter
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public void addDepartureFlight(Flight flight) {
        if (flight != null) {
            this.departures.add(flight);
            flightsByNumber.put(flight.getFlightNumber(), flight);
        }
    }

    public void removeDepartureFlight(Flight flight) {
        if (flight != null) {
            this.departures.remove(flight);
            flightsByNumber.remove(flight.getFlightNumber());
        }
    }
    public void addArrivalFlight(Flight flight) {
        this.arrivals.add(flight);
    }

    public void removeArrivalFlight(Flight flight) {
        this.arrivals.remove(flight);
    }
}

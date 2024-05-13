import java.util.ArrayList;
import java.util.List;

public class FlightsBag {
    private List<Flights> flightsBag;

    public FlightsBag() {
        flightsBag = new ArrayList<>();
    }

    public void addFlight(Flights flight) {
        flightsBag.add(flight);
    }

    public boolean removeFlight(Flights flight) {
        return flightsBag.remove(flight);
    }

    public int getFlightCount(Flights flight) {
        int count = 0;
        for (Flights f : flightsBag) {
            if (f.equals(flight)) {
                count++;
            }
        }
        return count;
    }

    public List<Flights> getAllFlights() {
        return new ArrayList<>(flightsBag);
    }
}

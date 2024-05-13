import Interfaces.FlightServiceCharter;

public class CharterFlight extends Flights implements FlightServiceCharter {
    //Overlapping inheritance class

    public CharterFlight(String flightNumber, String departureAirport, String arrivalAirport,FuelType fuelType) {
        super(flightNumber, departureAirport, arrivalAirport,fuelType);
    }

    @Override
    public void handleCharter() {
        arrangeSpecialSeating();
        prepareLuxuryAmenities();
        System.out.println("Charter flight preparations are complete.");
    }

    private void arrangeSpecialSeating() {
        System.out.println("Special seating arrangements have been made.");
    }

    private void prepareLuxuryAmenities() {
        System.out.println("Luxury amenities are prepared.");
    }

    @Override
    public void DisplayFlightDetails() {
        System.out.println("This is a Charter flight. Flight Number: " + getFlightNumber());
    }
}

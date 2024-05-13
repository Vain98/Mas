public class TestFlight extends Flights {

        //Abstract class' test class
    public TestFlight(String flightNumber, String departureAirport, String arrivalAirport, FuelType fuelType) {
        super(flightNumber, departureAirport, arrivalAirport, fuelType);
    }

    @Override
    public void DisplayFlightDetails() {
        System.out.println("Created new class because abstract class can not be instantiated directly");
    }



}

public abstract class Flights {
    private String FlightNumber;
    private String DepartureAirport;
    private String ArrivalAirport;

    private FuelType fuelType;


    public Flights(String flightNumber, String departureAirport, String arrivalAirport, FuelType fuelType) {
        FlightNumber = flightNumber;
        DepartureAirport = departureAirport;
        ArrivalAirport = arrivalAirport;
        this.fuelType = fuelType;
    }

    public abstract void DisplayFlightDetails();

    public String getFlightNumber() {
        return FlightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        FlightNumber = flightNumber;
    }

    public String getDepartureAirport() {
        return DepartureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        DepartureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return ArrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        ArrivalAirport = arrivalAirport;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "FlightNumber='" + FlightNumber + '\'' +
                ", DepartureAirport='" + DepartureAirport + '\'' +
                ", ArrivalAirport='" + ArrivalAirport + '\'' +
                '}';
    }
}

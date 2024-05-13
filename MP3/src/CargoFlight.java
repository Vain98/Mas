import Interfaces.FlightServiceCargo;

public class CargoFlight extends Flights implements FlightServiceCargo {
    //Overlapping inheritance class

    private boolean cargoReady;
    private int loadedCargoAmount;
    private final int cargoCapacity;

    public CargoFlight(String flightNumber, String departureAirport, String arrivalAirport, int cargoCapacity,FuelType fuelType) {
        super(flightNumber, departureAirport, arrivalAirport,fuelType);
        this.cargoReady = false;
        this.loadedCargoAmount = 0;
        this.cargoCapacity = cargoCapacity; // Set the cargo capacity

    }

    @Override
    public void handleCargo() {
        if (!cargoReady) {
            System.out.println("Cargo is not ready for loading.");
            return;
        }

        loadCargo(1200);
        secureCargo();
        updateCargoManifest();
    }

    private void loadCargo(int cargoAmount) {
        if (this.loadedCargoAmount + cargoAmount > this.cargoCapacity) {
            System.out.println("Cannot load " + cargoAmount + " units of cargo: Exceeds capacity of " + cargoCapacity + " units.");
            return;
        }

        this.loadedCargoAmount += cargoAmount; // Load the cargo
        System.out.println(cargoAmount + " units of cargo have been loaded onto the flight. Total loaded: " + loadedCargoAmount);
    }

    private void secureCargo() {
        System.out.println("Cargo has been secured.");
    }

    private void updateCargoManifest() {
        System.out.println("Cargo manifest has been updated.");
    }

    public void setCargoReady(boolean cargoReady) {
        this.cargoReady = cargoReady;
    }

    @Override
    public void DisplayFlightDetails() {
        System.out.println("This is a Cargo flight. Flight Number: " + getFlightNumber());
    }

}

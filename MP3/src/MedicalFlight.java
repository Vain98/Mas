import Interfaces.FlightServiceEmergency;

public class MedicalFlight extends Flights implements FlightServiceEmergency {
    //Overlapping inheritance class

    public MedicalFlight(String flightNumber, String departureAirport, String arrivalAirport,FuelType fuelType) {
        super(flightNumber, departureAirport, arrivalAirport,fuelType);
    }

    @Override
    public void handleEmergency() {
        prepareMedicalEquipment();
        coordinateWithMedicalStaff();
        ensureRapidTakeoffClearance();
        System.out.println("Emergency flight preparations are complete.");
    }

    private void prepareMedicalEquipment() {
        System.out.println("Medical equipment is prepared and checked.");
    }

    private void coordinateWithMedicalStaff() {
        System.out.println("Coordination with medical staff completed.");
    }

    private void ensureRapidTakeoffClearance() {
        System.out.println("Rapid takeoff clearance ensured.");
    }

    @Override
    public void DisplayFlightDetails() {
        System.out.println("This is a Medical Emergency flight. Flight Number: " + getFlightNumber());
    }
}


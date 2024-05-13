
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Mandatory attribute test
        testMandatoryAttribute();
        // Class attribute test
        testClassAttribute();
        // Complex attribute test
        testComplexAttribute();
        // Multi-value attribute test
        testMultiValueAttribute();
        // Optional attribute test
        testOptionalAttribute();
        // Derived attribute test
        testDerivedAttribute();
        // Class extent test
        testClassExtent();
        // Class methods test
        testClassMethods();
        // Method overriding test
        testMethodOverriding();
        //Constructor overloading test
        testConstructorOverloading();
    }

    private static void testMandatoryAttribute() {
        System.out.println("Testing Mandatory Attribute:");
        FlightNumber flightNumber = new FlightNumber("TK", "1234");
        Flight flight = new Flight(flightNumber, "Istanbul");
        System.out.println("Mandatory attribute (destination): " + flight.getDestination());
        System.out.println();
    }

    private static void testClassAttribute() {
        System.out.println("Testing Class Attribute:");
        System.out.println("Initial total flights: " + Flight.getTotalFlights());
        new Flight(new FlightNumber("TK", "2345"), "Istanbul");
        System.out.println("Total flights after adding a flight: " + Flight.getTotalFlights());
        System.out.println();
    }

    private static void testComplexAttribute() {
        System.out.println("Testing Complex Attribute:");
        FlightNumber flightNumber = new FlightNumber("TK", "3456");
        System.out.println("Complex attribute (flight number): " + flightNumber);
        System.out.println();
    }

    private static void testMultiValueAttribute() {
        System.out.println("Testing Multi-value Attribute:");
        Flight flight = new Flight(new FlightNumber("TK", "4567"), "New York");
        flight.addPassenger("Alice");
        flight.addPassenger("Bob");
        System.out.println("Passengers after additions: " + flight.getPassengers());
        flight.removePassenger("Alice");
        System.out.println("Passengers after removal: " + flight.getPassengers());
        System.out.println();
    }

    private static void testOptionalAttribute() {
        System.out.println("Testing Optional Attribute:");
        Flight flight = new Flight(new FlightNumber("TK", "5678"), "London");
        System.out.println("Before setting airline " + flight.getAirline());
        flight.setAirline("LOT");
        System.out.println("After setting airline " +flight.getAirline());
        System.out.println();
    }

    private static void testDerivedAttribute() {
        System.out.println("Testing Derived Attribute:");
        Flight flight = new Flight(new FlightNumber("TK", "6789"), "Paris");
        flight.setDepartureDateTime(LocalDateTime.now());
        flight.setArrivalTime(LocalDateTime.now().plusHours(10));
        System.out.println("Derived attribute (flight duration): " + flight.FlightDuration() + " hours");
        System.out.println();
    }

    private static void testClassExtent() {
        System.out.println("Testing Class Extent:");
        new Flight(new FlightNumber("TK", "7890"), "Berlin");
        System.out.println("Flight extent: " + Flight.getExtent());
        System.out.println();
    }

    private static void testClassMethods() {
        System.out.println("Testing Class Methods:");
        Flight.writeExtentToFile();
        Flight.readExtentFromFile();
        System.out.println("Class methods (extent file read/write) tested.");
        System.out.println();
    }

    private static void testMethodOverriding() {
        System.out.println("Testing Method Overriding:");
        Flight flight = new Flight(new FlightNumber("TK", "8901"), "Tokyo");
        System.out.println("Method overriding (toString): " + flight);
        System.out.println();
    }

    private static void testConstructorOverloading() {
        System.out.println("Testing Constructor Overloading:");
        Flight flightWithAirline = new Flight(new FlightNumber("TK", "9012"), "Madrid", "Delta", Arrays.asList("Alice", "Bob"));
        System.out.println("Constructor overloading with airline and passengers: " + flightWithAirline);
        System.out.println();
    }
}

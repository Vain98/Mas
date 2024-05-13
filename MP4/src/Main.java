import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Main {
    public static void main(String[] args) {

        //Testing XOR
        Flights internationalFlights = new Flights("1","INT123", FlightType.INTERNATIONAL, "Needed");
        Flights localFlights = new Flights("2","LOC456", FlightType.LOCAL, "Terminal 1");

        System.out.println(internationalFlights);
        System.out.println(localFlights);
        System.out.println("---------\n");

        //Testing Unique
        FlightManager flightManager=new FlightManager();
        Flights flight1 = new Flights("F001", "FL123", FlightType.INTERNATIONAL, "Needed");
        Flights flight2 = new Flights("F002", "FL456", FlightType.LOCAL, "Terminal 2");
        Flights flight3 = new Flights("F001", "FL789", FlightType.INTERNATIONAL, "Not needed");

        boolean addedFlight1 = flightManager.addFlight(flight1);
        boolean addedFlight2 = flightManager.addFlight(flight2);
        boolean addedFlight3 = flightManager.addFlight(flight3);

        System.out.println("Flight 1 added: " + addedFlight1);
        System.out.println("Flight 2 added: " + addedFlight2);
        System.out.println("Flight 3 added: " + addedFlight3);
        System.out.println("---------\n");

        //Testing subset
        flightManager.assignFlight(flight1);
        flightManager.assignFlight(flight2);

        flightManager.addPriorityFlight(flight1);

        try {
            Flights flight4 = new Flights("F003", "FL789", FlightType.INTERNATIONAL, "Visa needed");
            flightManager.addPriorityFlight(flight3);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Is Flight1 a priority flight? " + flightManager.isPriorityFlight(flight1));
        System.out.println("Is Flight2 a priority flight? " + flightManager.isPriorityFlight(flight2));
        System.out.println("---------\n");

        //Testing ordered
        Flights.addFlight(flight1);
        Flights.addFlight(flight2);

        SortedSet<Flights> orderedFlights = Flights.getFlights();
        for (Flights flight : orderedFlights) {
            System.out.println(flight.getFlightsID());
        }
        System.out.println("---------\n");

        // Testing bag
        List<Flights> flightsBag = new ArrayList<>();

        // Adding flights to the bag, including duplicates
        flightsBag.add(flight1);
        flightsBag.add(flight1); // Duplicate
        flightsBag.add(flight2);

        // Display all flights in bag
        System.out.println("Flights in the bag (including duplicates):");
        for (Flights flight : flightsBag) {
            System.out.println(flight);
        }

        // Count the occurrences of flight1 in the bag
        int countFlight1 = 0;
        for (Flights flight : flightsBag) {
            if (flight.getFlightsID().equals(flight1.getFlightsID())) {
                countFlight1++;
            }
        }
        System.out.println("Flight1 occurs " + countFlight1 + " times in the bag.");
        System.out.println("---------\n");

        //Testing custom constraint
        Flights internationalFlight = new Flights("1", "INT123", FlightType.INTERNATIONAL, "Visa not needed");

        Customer adultCustomer = new Customer("C001", "Alice", 25);
        Customer youngCustomer = new Customer("C002", "Bob", 17);


        if (adultCustomer.getAge() >= 18) {
            internationalFlight.addPassengerToInternationalFlight(adultCustomer);
            System.out.println("Adult customer added successfully.");
        } else {
            System.out.println("Adult customer not old enough for international flight.");
        }
        
        if (youngCustomer.getAge() >= 18) {
            internationalFlight.addPassengerToInternationalFlight(youngCustomer);
            System.out.println("Young customer added successfully.");
        } else {
            System.out.println("Young customer not old enough for international flight.");
        }
        System.out.println("---------\n");

        //Testing dynamic and static attributes

        Flights.ticket_price = 200.00;

        // Create flights with different discount rates
        Flights flightWithNoDiscount = new Flights("F006", "FL789", FlightType.INTERNATIONAL, "Visa needed", 0);
        Flights flightWithValidDiscount = new Flights("F007", "FL101", FlightType.LOCAL, "terminal 3", 20);


        try {
            flightWithValidDiscount.setDiscountRate(15); // Setting a discount within the limit
            System.out.println("Discount rate set to " + flightWithValidDiscount.getDiscountRate() + "% for flight " + flightWithValidDiscount.getFlightsNumber());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(flightWithNoDiscount);
        System.out.println(flightWithValidDiscount);


    }
}

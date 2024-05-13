import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        AirCraft airCraft1 = new AirCraft("D2134");
        Airport airport1 = new Airport("BAKU");
        Airport airport2 = new Airport("IST");
        Flight flight1 = new Flight("TK5678", airCraft1, airport1, airport2, new Passenger("Absua", "Aghha", "2435355"));
        Flight flight2 = new Flight("TK1234", airCraft1, airport1, airport2, new Passenger("Absua", "Aghha", "2435355"));


        //binary association
        System.out.println("Assigned at the moment: " + airCraft1.getAssignedFlights());

        airCraft1.removeFlight(flight1);

        System.out.println("Removed at the moment: " + airCraft1.getAssignedFlights());

        airCraft1.addFlight(flight2);
        System.out.println("Assigned flight after adding: " + airCraft1.getAssignedFlights());

        //composition
        Passenger passenger = new Passenger("Cem", "OSXKDCJk", "213441");
        Ticket ticket = Ticket.createTicket(passenger, "12a", flight1);

        System.out.println("Ticket's passenger: " + ticket.getPassenger());
        System.out.println("Passenger ticket: " + passenger.getTickets());

        passenger.removeTicket(ticket);
        System.out.println("Passenger ticket after removing: " + passenger.getTickets());


        //qualified
        System.out.println("List of passengers at the moment" + flight2.getPassengers());
        flight2.addPassenger(passenger);
        System.out.println("List of passengers after adding" + flight2.getPassengers());

        flight2.removePassenger(passenger);
        System.out.println("List of passengers after removing: " + flight2.getPassengers());


        //with attribute
        Crew crew = new Crew("111", "cree1", flight1);
        System.out.println("initial crew: " + crew);
        FlightAssignment flightAssignment1 = new FlightAssignment(crew, flight2, "crew");
        crew.addFlightAssignment(flightAssignment1);
        flight2.addFlightAssignment(flightAssignment1);

        System.out.println("Flight assignments of crew after adding: " + crew.getFlightAssignments());

        crew.removeFlightAssignment(flightAssignment1);
        System.out.println("Flight assignments of crew after removing: " + crew.getFlightAssignments());

        System.out.println("Flight assignments from the flight class: " + flight1.getFlightAssignments());

    }
}
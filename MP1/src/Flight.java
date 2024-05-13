import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Flight> extent = new ArrayList<>(); // Class attribute
    private LocalDateTime departureDateTime; //Part of derived attribute
    private LocalDateTime ArrivalTime;  //Part of derived attribute
    private FlightNumber flightNumber; // Complex attribute
    private String destination; // Mandatory attribute
    private String airline; // Optional attribute
    private List<String> passengers; // Multi-value attribute
    private static int totalFlights = 0;
    private int totalPassengers;
    private static int maxNumberOfPassengers=150;
    private  List<String>  TicketTypes= new ArrayList<>();

    public Flight(FlightNumber flightNumber, String destination, LocalDateTime DepartureDateTime, LocalDateTime ArrivalTime, List<String> Ticket) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureDateTime = DepartureDateTime;
        this.ArrivalTime = ArrivalTime;
        this.passengers = new ArrayList<>(); // Initialize the passengers list
        this.TicketTypes = new ArrayList<>(Ticket);
        extent.add(this);
        totalFlights++;
    }

    // Minimal constructor with flight number and destination
    public Flight(FlightNumber flightNumber, String destination) {
        this.flightNumber = flightNumber;
        setDestination(destination);
        this.passengers = new ArrayList<>(); // Initialize the passengers list
        // Add this flight to the extent and increment the total flights
        extent.add(this);
        totalFlights++;
    }

    // Constructor with flight number, destination, and airline
    public Flight(FlightNumber flightNumber, String destination, String airline, List<String> passengers) {
        this(flightNumber, destination);
        this.airline = airline;
        setPassengers(passengers);
    }


    public String getDestination() {
        return destination;
    }

    public List<String> getPassengers() {
        return Collections.unmodifiableList(this.passengers);
    }


    public static List<Flight> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static int getTotalFlights() {
        return totalFlights;
    }

    public int getTotalPassengers() {
        return totalPassengers;
    }

    public String getAirline() {
        return airline;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public double FlightDuration(){
        return ArrivalTime.getHour()-departureDateTime.getHour();
    }
    public void addTicketType(String type) {
        if(!this.TicketTypes.contains(type)){
            this.TicketTypes.add(type);
        }
    }

    public void addPassenger(String passenger) {
        if (passenger == null || passenger.isEmpty()) {
            throw new IllegalArgumentException("Passenger name can not be null or empty.");
        }
        passengers.add(passenger);
        updateTotalPassengers();
    }

    public void removePassenger(String passenger) {
        if (passenger == null || passenger.isEmpty()) {
            throw new IllegalArgumentException("Passenger name can not be null or empty.");
        }
        passengers.remove(passenger);
        updateTotalPassengers();
    }


    public void setPassengers(List<String> passengers) {
        if (passengers == null) {
            throw new IllegalArgumentException("Passengers list can not be null.");
        }
        this.passengers = new ArrayList<>(passengers);
        updateTotalPassengers();
    }
    public void setDestination(String destination) {
        if (destination == null || destination.isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be null or empty.");
        }
        this.destination = destination;
    }

    private void updateTotalPassengers() {
        totalPassengers = passengers.size();
    }
    public static List<Flight> getFlightWithMoreThan100passengers(){
        return extent.stream()
                .filter(Flight -> Flight.passengers.size() >100)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Flight{" +
                "departureDateTime=" + departureDateTime +
                ", ArrivalTime=" + ArrivalTime +
                ", flightNumber=" + flightNumber +
                ", destination='" + destination + '\'' +
                ", airline='" + airline + '\'' +
                ", passengers=" + passengers +
                ", totalPassengers=" + totalPassengers +
                ", TicketTypes=" + TicketTypes +
                '}';
    }

    public static void writeExtentToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("flights.ser"))) {
            outputStream.writeObject(extent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readExtentFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("flights.ser"))) {
            extent = (ArrayList<Flight>) inputStream.readObject();
            totalFlights = extent.size();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}

import java.io.*;
import java.util.*;

public class Flights implements Serializable {

    private String flightsID; //Unique
    private String flightsNumber;
    private FlightType flightType;
    private InternationalFlights internationalFlight;//xor
    private LocalFlights localFlight;//xor
    private static SortedSet<Flights> extent = new TreeSet<>(Comparator.comparing(Flights::getFlightsID));
    private List<Customer> passengers;
    public static double ticket_price = 100.00;//static attribute
    private double discount_rate;//dynamic attribute


    public Flights(String flightsID,String flightsNumber, FlightType flightType, String info) {
        this.flightsID=flightsID;
        this.flightsNumber = flightsNumber;
        this.passengers=new ArrayList<>();
        setFlightType(flightType, info);
    }

    public Flights(String flightsID, String flightsNumber, FlightType flightType, String info, double discountRate) {
        this.flightsID=flightsID;
        this.flightsNumber = flightsNumber;
        this.passengers=new ArrayList<>();
        setFlightType(flightType, info);
        setDiscountRate(discountRate); // Set the discount rate using the setter to enforce max discount
    }


    public String getFlightsID() {
        return flightsID;
    }

    public void setFlightsID(String flightsID) {
        this.flightsID = flightsID;
    }

    public String getFlightsNumber() {
        return flightsNumber;
    }

    public void setFlightsNumber(String flightsNumber) {
        this.flightsNumber = flightsNumber;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public InternationalFlights getInternationalFlight() {
        return internationalFlight;
    }

    public void setInternationalFlight(InternationalFlights internationalFlight) {
        if (internationalFlight != null){
            this.internationalFlight = internationalFlight;
        }
        this.localFlight = null;
    }

    public LocalFlights getLocalFlight() {
        return localFlight;
    }

    public void setLocalFlight(LocalFlights localFlight) {
        if (localFlight != null){
            this.localFlight = localFlight;
        }
        this.internationalFlight = null;
    }

    public void setFlightType(FlightType flightType, String info) {
        this.flightType = flightType;
        if (flightType == FlightType.INTERNATIONAL) {
            this.internationalFlight = new InternationalFlights(info);
            this.localFlight = null;
        } else {
            this.localFlight = new LocalFlights(info);
            this.internationalFlight = null;
        }
    }

    public static void saveExtent(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(extent);
        }
    }

    public static void loadExtent(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            extent = (SortedSet<Flights>) in.readObject();
        }
    }

    public static boolean removeFromExtent(String flightsID) {
        return extent.removeIf(flight -> flight.getFlightsID().equals(flightsID));
    }



    public static void addFlight(Flights flights) {
        extent.add(flights);
    }

    public static SortedSet<Flights> getFlights() {
        return extent;
    }

    public void addPassengerToInternationalFlight(Customer customer) {
        if (this.flightType != FlightType.INTERNATIONAL) {
            throw new IllegalArgumentException("This method is only for international flights.");
        }
        if (customer.getAge() < 18) {
            throw new IllegalArgumentException("Passengers must be over 18 to participate in an international flight.");
        }
        passengers.add(customer);
    }

    public double getDiscountRate() {
        return discount_rate;
    }

    public void setDiscountRate(double discountRate) {
        if (discountRate < 0) {
            throw new IllegalArgumentException("Discount rate cannot be negative.");
        } else if (discountRate > 30) {
            throw new IllegalArgumentException("Discount rate cannot exceed 30%.");
        }
        this.discount_rate = discountRate;
    }




    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightsNumber + '\'' +
                ", flightType=" + flightType +
                ", flightDetails=" + (flightType == FlightType.INTERNATIONAL ? internationalFlight : localFlight) +
                '}';
    }
}

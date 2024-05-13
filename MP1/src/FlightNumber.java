import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FlightNumber implements Serializable {

    private String FlightCode;
    private String FlightNumber;
    private static List<FlightNumber> extent=new ArrayList<>();

    public FlightNumber(String flightCode, String flightNumber) {
        if (isValidFlightCode(flightCode) && isValidFlightNumber(flightNumber)) {
            this.FlightCode = flightCode;
            this.FlightNumber = flightNumber;
        } else {
            throw new IllegalArgumentException("Invalid flight code or flight number");
        }
    }

    private boolean isValidFlightCode(String flightCode) {
        return flightCode != null && flightCode.matches("[a-zA-Z]{2}");
    }

    private boolean isValidFlightNumber(String flightNumber) {
        return flightNumber != null && flightNumber.matches("\\d{4}");
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
            extent = (List<FlightNumber>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "FlightNumber{" +
                "FlightCode='" + FlightCode + '\'' +
                ", FlightNumber='" + FlightNumber + '\'' +
                '}';
    }
}

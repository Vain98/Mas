package edu.pja.mas.cem.mp5.repository;

import edu.pja.mas.cem.mp5.Model.*;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BuilderTest {

    @Test
    public void testAircraftBuilder() {
        Aircraft aircraft = Aircraft.builder()
                .brand("Boeing")
                .build();

        assertThat(aircraft).isNotNull();
        assertThat(aircraft.getBrand()).isEqualTo("Boeing");
    }

    @Test
    public void testAirportBuilder() {
        Airport airport = Airport.builder()
                .airportname("WAW")
                .build();

        assertThat(airport).isNotNull();
        assertThat(airport.getAirportname()).isEqualTo("WAW");
    }

    @Test
    public void testCrewBuilder() {
        Crew crew = Crew.builder()
                .role("Captain")
                .build();

        assertThat(crew).isNotNull();
        assertThat(crew.getRole()).isEqualTo("Captain");
    }

    @Test
    public void testFlightsBuilder() {
        Flights flight = Flights.builder()
                .flightsnumber("TK2222")
                .build();

        assertThat(flight).isNotNull();
        assertThat(flight.getFlightsnumber()).isEqualTo("TK2222");
    }

    @Test
    public void testPassengerBuilder() {
        Passenger passenger = Passenger.builder()
                .name("John Doe")
                .build();

        assertThat(passenger).isNotNull();
        assertThat(passenger.getName()).isEqualTo("John Doe");
    }
}

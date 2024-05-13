package edu.pja.mas.cem.mp5.repository;

import edu.pja.mas.cem.mp5.Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AssociationTest {

    @Autowired
    private FlightsRepository flightsRepository;
    @Autowired
    private AircraftRepository aircraftRepository;
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private CrewRepository crewRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    private Aircraft aircraft;
    private Airport departureAirport, arrivalAirport;
    private Crew crewMember;
    private Passenger passenger;

    @BeforeEach
    public void initData() {
        aircraft = Aircraft.builder().brand("Boeing").build();
        departureAirport = Airport.builder().airportname("WAW").build();
        arrivalAirport = Airport.builder().airportname("IST").build();
        crewMember = Crew.builder().role("Captain").build();
        passenger = Passenger.builder().name("John Doe").build();

        aircraftRepository.save(aircraft);
        airportRepository.save(departureAirport);
        airportRepository.save(arrivalAirport);
        crewRepository.save(crewMember);
        passengerRepository.save(passenger);
    }

    @Test
    public void testFlightAssociation() {
        Flights flight = Flights.builder()
                .flightsnumber("TK2222")
                .aircraft(aircraft)
                .departureAirport(departureAirport)
                .arrivalAirport(arrivalAirport)
                .crewMembers(new HashSet<>())
                .passengers(new HashSet<>())
                .build();

        flight.getCrewMembers().add(crewMember);
        flight.getPassengers().add(passenger);
        flightsRepository.save(flight);

        Flights retrievedFlight = flightsRepository.findById(flight.getIdflights()).orElse(null);
        assertThat(retrievedFlight).isNotNull();
        assertThat(retrievedFlight.getAircraft()).isEqualTo(aircraft);
        assertThat(retrievedFlight.getDepartureAirport()).isEqualTo(departureAirport);
        assertThat(retrievedFlight.getArrivalAirport()).isEqualTo(arrivalAirport);
        assertThat(retrievedFlight.getCrewMembers()).contains(crewMember);
        assertThat(retrievedFlight.getPassengers()).contains(passenger);
    }
}

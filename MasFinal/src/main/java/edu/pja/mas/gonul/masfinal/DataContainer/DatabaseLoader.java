package edu.pja.mas.gonul.masfinal.DataContainer;

import edu.pja.mas.gonul.masfinal.Enums.FlightClass;
import edu.pja.mas.gonul.masfinal.Enums.LoyaltyProgramBenefits;
import edu.pja.mas.gonul.masfinal.Enums.loyaltyTypes;
import edu.pja.mas.gonul.masfinal.Repositories.*;
import edu.pja.mas.gonul.masfinal.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;
    private final TicketRepository ticketRepository;
    private final AircraftRepository aircraftRepository;
    private final AirlineRepository airlineRepository;

    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public DatabaseLoader(PassengerRepository passengerRepository,
                          FlightRepository flightRepository,
                          AirportRepository airportRepository, TicketRepository ticketRepository, AircraftRepository aircraftRepository, AirlineRepository airlineRepository, MaintenanceRepository maintenanceRepository) {
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
        this.ticketRepository = ticketRepository;
        this.aircraftRepository = aircraftRepository;
        this.airlineRepository = airlineRepository;
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (airportRepository.count() == 0 && airlineRepository.count() == 0 && aircraftRepository.count() == 0 && passengerRepository.count() == 0) {

            Airport airport1 = Airport.builder()
                    .airportCode("CDG")
                    .airportName("Charles de Gaulle Airport")
                    .location("Paris, France")
                    .terminals(Arrays.asList("Terminal 1", "Terminal 2"))
                    .gates(Arrays.asList("Gate A", "Gate B"))
                    .build();

            Airport airport2 = Airport.builder()
                    .airportCode("IST")
                    .airportName("Istanbul Airport")
                    .location("Istanbul, Turkiye")
                    .terminals(Arrays.asList("Terminal A", "Terminal B"))
                    .gates(Arrays.asList("Gate C", "Gate D"))
                    .build();

            Airport warsawAirport = Airport.builder()
                    .airportCode("WAW")
                    .airportName("Warsaw Chopin Airport")
                    .location("Warsaw")
                    .terminals(Arrays.asList("Terminal A", "Terminal B"))
                    .gates(Arrays.asList("Gate 1", "Gate 2", "Gate 3"))
                    .build();

            Airport krakowAirport = Airport.builder()
                    .airportCode("KRK")
                    .airportName("Krakow John Paul II International Airport")
                    .location("Krakow")
                    .terminals(Arrays.asList("Terminal 1", "Terminal 2"))
                    .gates(Arrays.asList("Gate 4", "Gate 5"))
                    .build();

            Airport gdanskAirport = Airport.builder()
                    .airportCode("GDN")
                    .airportName("Gdansk Lech Walesa Airport")
                    .location("Gdansk")
                    .terminals(Arrays.asList("Main Terminal"))
                    .gates(Arrays.asList("Gate 6", "Gate 7", "Gate 8"))
                    .build();

            airportRepository.saveAll(Arrays.asList(airport1, airport1, krakowAirport, gdanskAirport, warsawAirport));


            Passenger passenger1 = Passenger.builder()
                    .full_name("John Doe")
                    .loyaltyType(loyaltyTypes.BUSINESS)
                    .speacialneeds(false)
                    .luggageItems(Arrays.asList("Carry-on bag", "Personal item"))
                    .build();

            Passenger passenger2 = Passenger.builder()
                    .full_name("Jane Smith")
                    .loyaltyType(loyaltyTypes.BUSINESSEXTRA)
                    .speacialneeds(true)
                    .luggageItems(Arrays.asList("Checked bag", "Backpack"))
                    .build();


            InternationalFlight internationalFlight = InternationalFlight.builder()
                    .departureTime(LocalDateTime.now())
                    .arrivalTime(LocalDateTime.now().plusHours(10))
                    .origin(airport1.getAirportName())
                    .destination(airport2.getAirportName())
                    .visaRequirements(false)
                    .mealOptions(Arrays.asList("Chicken", "Vegetarian"))
                    .entertainmentOptions(Arrays.asList("Movies", "Music"))
                    .build();


            LocalFlight localFlight1 = LocalFlight.builder()
                    .departureTime(LocalDateTime.now())
                    .arrivalTime(LocalDateTime.now().plusHours(2))
                    .origin(warsawAirport.getAirportName())
                    .destination(gdanskAirport.getAirportName())
                    .wifiAvailability(true)
                    .build();

            LocalFlight localFlight2 = LocalFlight.builder()
                    .departureTime(LocalDateTime.now())
                    .arrivalTime(LocalDateTime.now().plusHours(2))
                    .origin(warsawAirport.getAirportName())
                    .destination(krakowAirport.getAirportName())
                    .wifiAvailability(true)
                    .build();

            LocalFlight localFlight3 = LocalFlight.builder()
                    .departureTime(LocalDateTime.now())
                    .arrivalTime(LocalDateTime.now().plusHours(2))
                    .origin(airport2.getAirportCode())
                    .destination(airport1.getAirportCode())
                    .wifiAvailability(true)
                    .build();

            Ticket ticket1 = Ticket.builder()
                    .seatNumber("12A")
                    .flightClass(FlightClass.FIRSTCLASS)
                    .passenger(passenger1)
                    .price(200)
                    .flight(localFlight3)
                    .build();
            Ticket ticket2 = Ticket.builder()
                    .seatNumber("11A")
                    .flightClass(FlightClass.FIRSTCLASS)
                    .passenger(passenger1)
                    .price(250)
                    .flight(localFlight2)
                    .build();

            Ticket ticket3 = Ticket.builder()
                    .seatNumber("34B")
                    .flightClass(FlightClass.NORMALCLASS)
                    .passenger(passenger2)
                    .price(250)
                    .flight(localFlight3)
                    .build();

            Airline airline1 = Airline.builder()
                    .airlineCode("TK")
                    .name("THY")
                    .build();
            Airline airline2 = Airline.builder()
                    .airlineCode("LOT")
                    .name("LOT")
                    .build();

            Airline airline3 = Airline.builder()
                    .airlineCode("LF")
                    .name("LUFTHANSA")
                    .build();
            Cargo cargoAircraft = Cargo.builder()
                    .model("Boeing 747F")
                    .description("Heavy cargo transport")
                    .cargoCapacity(100.0)
                    .build();
            Medical medicalAircraft = Medical.builder()
                    .model("Airbus H135")
                    .medicalEquipments("Advanced Life Support Equipment")
                    .patientCapacity(2)
                    .build();
            Touristic touristicAircraft = Touristic.builder()
                    .model("Cessna 172")
                    .loyaltyProgramBenefits(Set.of(LoyaltyProgramBenefits.FREE_MEALS, LoyaltyProgramBenefits.EXTRA_LUGGAGE))
                    .build();

            Maintenance maintenance1 = Maintenance.builder()
                    .maintanceDate(LocalDateTime.now().minusMonths(2))
                    .aircraft(cargoAircraft)
                    .build();

            Maintenance maintenance2 = Maintenance.builder()
                    .maintanceDate(LocalDateTime.now().minusMonths(1))
                    .aircraft(medicalAircraft)
                    .build();

            Maintenance maintenance3 = Maintenance.builder()
                    .maintanceDate(LocalDateTime.now().minusWeeks(3))
                    .aircraft(touristicAircraft)
                    .build();


            airportRepository.saveAll(Arrays.asList(airport1, airport1, krakowAirport, gdanskAirport, warsawAirport));
            airlineRepository.saveAll(Arrays.asList(airline1, airline2, airline3));
            aircraftRepository.saveAll(Arrays.asList(cargoAircraft, medicalAircraft, touristicAircraft));
            passengerRepository.saveAll(Arrays.asList(passenger1, passenger2));
            flightRepository.saveAll(Arrays.asList(localFlight1, localFlight2, localFlight3, internationalFlight));
            ticketRepository.saveAll(Arrays.asList(ticket1, ticket2, ticket3));
            maintenanceRepository.saveAll(Arrays.asList(maintenance1, maintenance2, maintenance3));
        }
    }
}


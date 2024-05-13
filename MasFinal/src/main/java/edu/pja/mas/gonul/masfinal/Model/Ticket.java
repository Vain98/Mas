package edu.pja.mas.gonul.masfinal.Model;

import edu.pja.mas.gonul.masfinal.Enums.FlightClass;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_number;

    @Column(name = "seat_number",nullable = false)
    @Pattern(regexp = "([1-9]|1[0-9]|2[0-9]|3[0-4])[A-D]", message = "Seat number must be between 1A and 34D.")
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name="flight_class",nullable = false)
    private FlightClass flightClass;

    @Column(name="price",nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id",nullable = false)
    private Passenger passenger;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="agency_id")
    private BookingAgency bookingAgency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;



}

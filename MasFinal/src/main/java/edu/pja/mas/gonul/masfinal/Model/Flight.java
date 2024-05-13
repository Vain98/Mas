package edu.pja.mas.gonul.masfinal.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@SuperBuilder
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "flight_type")
public abstract class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;


    @Column(name="departure_time",nullable = false)
    private LocalDateTime departureTime;

    @Column(name="arrival_time",nullable = false)
    private LocalDateTime arrivalTime;

    @Column(name="origin",nullable = false)
    private String origin;

    @Column(name="destination",nullable = false)
    private String destination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_code")
    private Airport originAirport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_code")
    private Airport destinationAirport;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> tickets = new HashSet<>();

    @OneToMany(mappedBy = "flight",  orphanRemoval = true)
    private List<FlightInstance> flightInstances;



}

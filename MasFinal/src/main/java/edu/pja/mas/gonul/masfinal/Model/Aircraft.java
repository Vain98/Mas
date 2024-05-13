package edu.pja.mas.gonul.masfinal.Model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuperBuilder
@DiscriminatorValue("aircraft_type")
public abstract class Aircraft {
    @Id
    @Column(name="aircraftIds")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aircraftId;

    @Column(name="model",nullable = false)
    private String model;

    @OneToMany(mappedBy = "assignedAircraft", orphanRemoval = true)
    private Set<FlightInstance> assignedFlightInstances;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_code", nullable = true)
    private Airline airline;

    @OneToMany(mappedBy = "aircraft", orphanRemoval = true)
    private List<Maintenance> maintenanceRecords;



}

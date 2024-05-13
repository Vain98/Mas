package edu.pja.mas.gonul.masfinal.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long crewId;


    @Column(name="crew_name",nullable = false)
    private String crewName;

    @OneToMany(mappedBy = "assignedCrew", orphanRemoval = true)
    private Set<FlightInstance> assignedFlightInstances;


}

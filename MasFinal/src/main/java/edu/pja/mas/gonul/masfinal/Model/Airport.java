package edu.pja.mas.gonul.masfinal.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airport {

    @Id
    @Column(name = "airport_code", nullable = false)
    private String airportCode;

    @Column(name = "airport_name", nullable = false)
    private String airportName;

    @Column(name = "location", nullable = false)
    private String location;

    @ElementCollection
    @CollectionTable(
            name = "airport_terminals",
            joinColumns = @JoinColumn(name = "airport_code", referencedColumnName = "airport_code")
    )
    private List<String> terminals;

    @ElementCollection
    @CollectionTable(
            name = "airport_gates",
            joinColumns = @JoinColumn(name = "airport_code", referencedColumnName = "airport_code")
    )
    private List<String> gates;

    @OneToMany(mappedBy = "originAirport", fetch = FetchType.LAZY)
    private Set<Flight> departingFlights = new HashSet<>();

    @OneToMany(mappedBy = "destinationAirport", fetch = FetchType.LAZY)
    private Set<Flight> arrivingFlights = new HashSet<>();

}

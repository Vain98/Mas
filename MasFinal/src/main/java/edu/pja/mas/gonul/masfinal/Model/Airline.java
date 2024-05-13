package edu.pja.mas.gonul.masfinal.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airline {
    @Id
    private String airlineCode;

    @Column(name="names",nullable = false)
    private String name;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL)
    private Set<Aircraft> aircraftFleet = new HashSet<>();


}

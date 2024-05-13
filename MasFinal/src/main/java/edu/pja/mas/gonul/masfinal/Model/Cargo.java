package edu.pja.mas.gonul.masfinal.Model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("Cargo")
public class Cargo extends Aircraft {


    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private Double cargoCapacity;


}

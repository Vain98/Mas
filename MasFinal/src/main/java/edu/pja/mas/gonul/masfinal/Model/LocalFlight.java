package edu.pja.mas.gonul.masfinal.Model;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("Local")
public class LocalFlight extends Flight{

    @Column(name="wifi")
    private boolean wifiAvailability;
}

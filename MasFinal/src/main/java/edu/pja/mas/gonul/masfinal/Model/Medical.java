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
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("medical")
public class Medical extends Aircraft {


    @Column(nullable = true)
    private String medicalEquipments;

    @Column(nullable = true)
    private int patientCapacity;


}

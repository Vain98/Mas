package edu.pja.mas.gonul.masfinal.Model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("International")

public class InternationalFlight extends Flight{
    @Column(name="visa_requirements",nullable = true)
    private boolean visaRequirements;


    @ElementCollection
    @Column(name="meals")
    private List<String> mealOptions;


    @ElementCollection
    @Column(name="entertainment_options")
    private List<String> entertainmentOptions;



}

package edu.pja.mas.gonul.masfinal.Model;

import edu.pja.mas.gonul.masfinal.Enums.LoyaltyProgramBenefits;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;
@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("touristic")
public class Touristic extends Aircraft {

    @ElementCollection
    @CollectionTable(name = "touristic_benefits", joinColumns = @JoinColumn(name = "touristic_id"))
    @Enumerated(EnumType.STRING)
    private Set<LoyaltyProgramBenefits> loyaltyProgramBenefits;

}


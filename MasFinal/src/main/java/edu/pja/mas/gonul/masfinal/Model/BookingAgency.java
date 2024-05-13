package edu.pja.mas.gonul.masfinal.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingAgency {
    @Id
    private Long agencyID;

    @Column(name="Agency_name",nullable = false)
    private String name;

    @Column(name="contact_information",nullable = false)
    private String contactInfo;

    @OneToMany(mappedBy = "bookingAgency")
    private Set<Ticket> tickets = new HashSet<>();
}

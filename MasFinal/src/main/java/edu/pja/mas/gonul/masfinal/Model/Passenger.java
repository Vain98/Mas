package edu.pja.mas.gonul.masfinal.Model;

import edu.pja.mas.gonul.masfinal.Enums.loyaltyTypes;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
public class Passenger {
    public static final int max_fullname_length=60;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerId;

    @Column(name="full_name",nullable = false,length = max_fullname_length)
    private String full_name;

    @Enumerated(EnumType.STRING)
    @Column(name="loyalty_type",nullable = false)
    private loyaltyTypes loyaltyType;

    @Column(name = "specialneeds",nullable = false)
    private boolean speacialneeds;

    @ElementCollection
    @CollectionTable(name = "passenger_luggage", joinColumns = @JoinColumn(name = "passenger_id"))
    @Column(name="luggage_item")
    private List<String> luggageItems=new ArrayList<>();

    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();




}


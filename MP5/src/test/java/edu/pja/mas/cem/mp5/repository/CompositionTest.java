package edu.pja.mas.cem.mp5.repository;

import edu.pja.mas.cem.mp5.Model.Aircraft;
import edu.pja.mas.cem.mp5.Model.Engine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CompositionTest {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private EngineRepository engineRepository;

    private Aircraft aircraft;
    private Set<Engine> engines;

    @BeforeEach
    public void initData() {
        engines = new HashSet<>();
        engines.add(Engine.builder().type("Jet Engine").build());
        engines.add(Engine.builder().type("Turbofan Engine").build());

        aircraft = Aircraft.builder()
                .brand("Boeing")
                .engines(engines)
                .build();
    }


    @Test
    public void testAircraftComposition() {
        Aircraft savedAircraft = aircraftRepository.save(aircraft);

        assertThat(savedAircraft).isNotNull();
        assertThat(savedAircraft.getId()).isNotNull();
        assertThat(savedAircraft.getBrand()).isEqualTo("Boeing");

        assertThat(savedAircraft.getEngines()).hasSize(2);

        savedAircraft.getEngines().forEach(engine -> {
            assertThat(engine.getId()).isNotNull();

        });


    }
}


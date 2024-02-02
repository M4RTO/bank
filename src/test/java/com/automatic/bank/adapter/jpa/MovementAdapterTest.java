package com.automatic.bank.adapter.jpa;

import com.automatic.bank.domain.Movement;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@DisplayName("Test jpa adapter movement")
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MovementAdapterTest {

    @Autowired
    private MovementJPARepository repository;

    private static MovementAdapter adapter;

    @BeforeAll
    public void setUp() {

        adapter = new MovementAdapter(repository);
    }
    @Test
    @DisplayName("Test find all movements with params ")
    public void tesFindAllWithParams() {
        List<Movement> movements = adapter.findAllByAccountIdAndMovementType(1L, "1");
        Assertions.assertEquals("una transaccion mas",movements.get(0).getDescription());
    }
}

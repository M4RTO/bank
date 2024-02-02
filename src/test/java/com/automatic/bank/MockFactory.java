package com.automatic.bank;

import com.automatic.bank.adapter.controller.model.MovementModelRest;
import com.automatic.bank.adapter.controller.model.MovementModelTypeRest;
import com.automatic.bank.domain.Movement;
import com.automatic.bank.domain.MovementType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.List;


public class MockFactory {


    public static List<MovementModelRest> getMovementsResponse() {
        return List.of(
                MovementModelRest.builder()
                     .id(1L)
                     .accountId(1L)
                     .movementType(MovementModelTypeRest.builder()
                             .id(1L)
                             .name("Deposit")
                             .build())
                     .amount(100.0)
                     .description("Deposit")
                        .createdOn("2024-12-31")
                     .build(),
                MovementModelRest.builder()
                     .id(2L)
                     .accountId(1L)
                     .movementType(MovementModelTypeRest.builder()
                             .id(2L)
                             .name("Withdraw")
                             .build())
                     .amount(100.0)
                     .description("Withdraw")
                        .createdOn("2024-12-31")
                        .build()
        );
    }

    public static List<Movement> getMovementsEntity() {
        return List.of(
                Movement.builder()
                    .id(1L)
                    .accountId(1L)
                    .type(MovementType.builder().id(1L).name("Deposit").build())
                    .amount(100.0)
                    .description("Deposit")
                        .createdOn(LocalDate.of(2024, 12, 31))
                    .build(),
                Movement.builder()
                    .id(2L)
                    .accountId(1L)
                        .type(MovementType.builder().id(2L).name("Withdraw").build())
                    .amount(100.0)
                    .description("Withdraw")
                        .createdOn(LocalDate.of(2024, 12, 31))
                        .build()
        );
    }
}

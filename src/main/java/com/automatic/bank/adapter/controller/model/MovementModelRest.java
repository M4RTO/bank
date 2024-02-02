package com.automatic.bank.adapter.controller.model;

import com.automatic.bank.domain.Movement;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MovementModelRest {

    private Long id;

    private Long accountId;

    private MovementModelTypeRest movementType;

    private Double amount;

    private String createdOn;

    private String description;

    public static final DateTimeFormatter FORMAT_PARSER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static List<MovementModelRest> toMovementRestList(List<Movement> movementList) {
        return movementList.stream()
             .map(MovementModelRest::toMovementRest)
             .toList();
    }

    private static MovementModelRest toMovementRest(Movement movement) {
        return MovementModelRest.builder()
              .id(movement.getId())
              .accountId(movement.getAccountId())
              .movementType(MovementModelTypeRest.toMovementModelTypeRest(movement.getType()))
              .amount(movement.getAmount())
              .description(movement.getDescription())
                .createdOn(movement.getCreatedOn().format(FORMAT_PARSER))
              .build();
    }
}




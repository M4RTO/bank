package com.automatic.bank.adapter.controller.model;

import com.automatic.bank.domain.MovementType;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MovementModelTypeRest {
    private Long id;
    private String name;

    static MovementModelTypeRest toMovementModelTypeRest(MovementType movementType) {
        return MovementModelTypeRest.builder()
                .id(movementType.getId())
                .name(movementType.getName())
                .build();
    }

}

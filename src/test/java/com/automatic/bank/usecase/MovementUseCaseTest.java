package com.automatic.bank.usecase;

import com.automatic.bank.MockFactory;
import com.automatic.bank.application.port.out.GetMovementsPortOut;
import com.automatic.bank.application.usecase.MovementUseCase;
import com.automatic.bank.domain.Movement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("Movement useCase")
@ExtendWith(MockitoExtension.class)
public class MovementUseCaseTest {

    @Mock
    private GetMovementsPortOut movementsPortOut;

    @InjectMocks
    MovementUseCase movementUseCase;

    @Test
    void getMovementsByMovementTypeAndAccountId() {
        final var expected = MockFactory.getMovementsEntity();

        when(movementsPortOut.findAllByAccountIdAndMovementType(any(),any()))
                .thenReturn(MockFactory.getMovementsEntity());

        List<Movement> entities = movementUseCase.execute(any(), any());

        Assertions.assertEquals(expected, entities);
    }
}

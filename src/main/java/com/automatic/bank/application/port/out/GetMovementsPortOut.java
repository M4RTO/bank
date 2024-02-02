package com.automatic.bank.application.port.out;

import com.automatic.bank.domain.Movement;

import java.util.List;

public interface GetMovementsPortOut {

    List<Movement> findAllByAccountIdAndMovementType(Long accountId, String movementType);

}

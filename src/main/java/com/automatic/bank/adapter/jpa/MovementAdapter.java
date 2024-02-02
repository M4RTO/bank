package com.automatic.bank.adapter.jpa;

import com.automatic.bank.application.port.out.GetMovementsPortOut;
import com.automatic.bank.config.exception.MovementsNotFoundException;
import com.automatic.bank.domain.Movement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class MovementAdapter implements GetMovementsPortOut {

    private final MovementJPARepository repository;

    @Autowired
    public MovementAdapter(MovementJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Movement> findAllByAccountIdAndMovementType(Long accountId, String movementType) {
        Optional<List<Movement>> optionalList = repository.findAllByAccountIdAndTypeId(accountId, Long.valueOf(movementType));
        return ensureMovementsIsFound(optionalList);

    }

    private List<Movement> ensureMovementsIsFound(Optional<List<Movement>> entity) {
        if (entity.isEmpty() || entity.get().isEmpty()) {
            throw new MovementsNotFoundException("Not Found Movements with these params");
        } else {
            return entity.get();
        }
    }
}

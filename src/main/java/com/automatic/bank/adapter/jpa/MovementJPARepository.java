package com.automatic.bank.adapter.jpa;

import com.automatic.bank.domain.Movement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MovementJPARepository extends CrudRepository<Movement, Long> {
    Optional<List<Movement>> findAllByAccountIdAndTypeId(Long accountId, Long movementType);
}

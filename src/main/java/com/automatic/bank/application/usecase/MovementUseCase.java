package com.automatic.bank.application.usecase;

import com.automatic.bank.application.in.GetMovementsPortIn;
import com.automatic.bank.domain.Movement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class MovementUseCase implements GetMovementsPortIn {
    @Override
    public List<Movement> execute(Long accountId, String type) {
        return new ArrayList<Movement>();
    }
}

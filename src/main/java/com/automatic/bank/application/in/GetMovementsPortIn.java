package com.automatic.bank.application.in;

import com.automatic.bank.domain.Movement;

import java.util.List;

public interface GetMovementsPortIn {

    List<Movement> execute(Long accountId, String type);

}

package com.automatic.bank.adapter.controller;

import com.automatic.bank.adapter.controller.model.MovementModelRest;
import com.automatic.bank.application.in.GetMovementsPortIn;
import com.automatic.bank.domain.Movement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/banks")
public class BankControllerAdapter {

    private final GetMovementsPortIn getMovementsPortIn;

    @Autowired
    public BankControllerAdapter(GetMovementsPortIn getMovementsPortIn) {
        this.getMovementsPortIn = getMovementsPortIn;
    }

    @Operation(summary = "Get movements by account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get movements by id to specific movement",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "400", description = "Accountid is mandatory",
                    content = @Content)})
    @GetMapping("/{accountId}")
    public ResponseEntity<List<MovementModelRest>> getMovements(
            @PathVariable Long accountId,
            @RequestParam String type
    ) {
        //log.info("Get movements with this accountId {} and this type {}", accountId, type);
        List<Movement> movementList = getMovementsPortIn.execute(accountId, type);
        List<MovementModelRest> movementRest = MovementModelRest.toMovementRestList(movementList);
        //log.info("Get response: {}", movementRest);
        return new ResponseEntity<>(movementRest, HttpStatus.OK);


    }
}

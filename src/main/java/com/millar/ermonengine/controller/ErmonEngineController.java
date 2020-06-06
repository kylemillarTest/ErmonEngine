package com.millar.ermonengine.controller;

import com.millar.ermonengine.controller.model.game.SitRequest;
import com.millar.ermonengine.controller.model.game.SitResponse;
import com.millar.ermonengine.controller.model.hand.NextRoundRequest;
import com.millar.ermonengine.controller.model.hand.NextRoundResponse;
import com.millar.ermonengine.controller.model.player.*;
import com.millar.ermonengine.controller.model.table.*;
import com.millar.ermonengine.dao.model.Table;
import com.millar.ermonengine.dao.model.TableId;
import com.millar.ermonengine.dao.repository.TableRepository;
import com.millar.ermonengine.table.create.CreateTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//TODO: rename to new microservicey name
@RestController
@RequiredArgsConstructor
public class ErmonEngineController {

    private final CreateTableService createTableService;
    private final TableRepository tableRepository;

    //1. create table
    //2. create game
    @PostMapping("/v1/table/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTableResponse createTable(@RequestBody @Valid CreateTableRequest request) {
        return createTableService.createTable(request);
    }

    //TODO: remove when done with tests
    @GetMapping("/{name}/{owner}")
    public Table getTable(@PathVariable("name") String name, @PathVariable("owner") String owner) {
        return tableRepository.findById(new TableId(name, owner)).get();
    }

    //---Join
    //1. add new player
    //***Game should always exist. Create table creates game, and timer creates new game on existing table
    @PutMapping("/v1/join/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JoinResponse> join(@RequestBody @Valid JoinRequest request) {
        return ResponseEntity.ok().build();
    }

    //---Sit-in
    //1. add new player
    //2. add buy-in (if wanted/necessary)
    //---Sit-out
    //1. remove player
    @PutMapping("/v1/sit/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SitResponse> sit(@RequestBody @Valid SitRequest request) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/v1/{handId}/round/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NextRoundRequest> nextRound(@RequestBody NextRoundResponse nextRoundResponse) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/v1/{playerId}/fold/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FoldResponse> fold(@RequestBody FoldRequest request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/v1/{playerId}/check/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CheckResponse> check(@RequestBody CheckRequest request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/v1/{playerId}/bet/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BetResponse> bet(@RequestBody BetResponse response) {
        return ResponseEntity.ok().build();
    }
}

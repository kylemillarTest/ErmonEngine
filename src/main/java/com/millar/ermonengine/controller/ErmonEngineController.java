package com.millar.ermonengine.controller;

import com.millar.ermonengine.controller.model.game.SitRequest;
import com.millar.ermonengine.controller.model.game.SitResponse;
import com.millar.ermonengine.controller.model.hand.NextRoundRequest;
import com.millar.ermonengine.controller.model.hand.NextRoundResponse;
import com.millar.ermonengine.controller.model.player.*;
import com.millar.ermonengine.controller.model.table.*;
import com.millar.ermonengine.dao.model.Game;
import com.millar.ermonengine.dao.model.Table;
import com.millar.ermonengine.dao.model.TableId;
import com.millar.ermonengine.dao.repository.GameRepository;
import com.millar.ermonengine.dao.repository.TableRepository;
import com.millar.ermonengine.game.update.sit.SeatManager;
import com.millar.ermonengine.table.create.CreateTable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/ermonengine")
public class ErmonEngineController {

    private final CreateTable createTable;
    private final SeatManager seatManager;
    private final GameRepository gameRepository;
    private final TableRepository tableRepository;

    //1. create table
    //2. create game
    //***Game should always exist. Create table creates game, and timer creates new game on existing table
    @PostMapping("/table/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateTableResponse createTable(@RequestBody @Valid CreateTableRequest request) {
        return createTable.createTable(request);
    }

    //TODO: formalize this
    @GetMapping("/{name}/{owner}")
    public Table getTable(@PathVariable("name") String name, @PathVariable("owner") String owner) {
        return tableRepository.findById(new TableId(name, owner)).get();
    }

    //TODO: formalize this
    @GetMapping("/{name}/{owner}/{gameId}")
    public Game getGame(@PathVariable("name") String name, @PathVariable("owner") String owner, @PathVariable String gameId) {
        return gameRepository.findById(new TableId(new TableId(name, owner), gameId)).get();
    }

    //---Sit-in
    //1. add new player
    //2. add buy-in (if wanted/necessary)
    //---Sit-out
    //1. remove player
    @PutMapping("/sit/")
    @ResponseStatus(HttpStatus.OK)
    public SitResponse sit(@RequestBody @Valid SitRequest request) {
        return seatManager.sit(request);
    }

    @PostMapping("/{handId}/round/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<NextRoundRequest> nextRound(@RequestBody NextRoundResponse nextRoundResponse) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{playerId}/fold/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FoldResponse> fold(@RequestBody FoldRequest request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{playerId}/check/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CheckResponse> check(@RequestBody CheckRequest request) {
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{playerId}/bet/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BetResponse> bet(@RequestBody BetResponse response) {
        return ResponseEntity.ok().build();
    }
}

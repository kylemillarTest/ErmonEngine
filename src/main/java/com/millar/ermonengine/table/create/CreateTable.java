package com.millar.ermonengine.table.create;

import com.millar.ermonengine.controller.model.table.CreateTableRequest;
import com.millar.ermonengine.controller.model.table.CreateTableResponse;
import com.millar.ermonengine.dao.model.Game;
import com.millar.ermonengine.dao.model.Table;
import com.millar.ermonengine.game.create.CreateGame;
import com.millar.ermonengine.table.TableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateTable {

    private final CreateGame createGame;
    private final TableService tableService;

    public CreateTableResponse createTable(CreateTableRequest request) {
        log.info("Creating table... {}", request.getTableName());

        Table table = tableService.createTable(request.getTableName(), request.getTableOwner(), request.getRuleSet());
        Game game = createGame.createGame(table.getTableId());

        log.info("Table created.");
        return new CreateTableResponse(table.getName(), table.getOwner(), table.getRuleSet(), table.getStatus(),
                game.getGameId(), game.getStatus(), table.getCreatedAt());
    }
}

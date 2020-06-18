package com.millar.ermonengine.controller.model.table;

import com.millar.ermonengine.game.GameStatus;
import com.millar.ermonengine.table.TableStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
@RequiredArgsConstructor
public class CreateTableResponse {
    private final String name;
    private final String owner;
//    private final List<String> adminList;
    private final String ruleSet;
    private final TableStatus tableStatus;
    private final String gameId;
    private final GameStatus gameStatus;
    private final Instant createdAt;
}

package com.millar.ermonengine.game.create;

import com.millar.ermonengine.dao.model.Game;
import com.millar.ermonengine.dao.model.TableId;
import com.millar.ermonengine.game.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateGame {

    private final GameService gameService;

    public Game createGame(TableId tableId) {
        return gameService.createGame(tableId);
    }
}

package com.millar.ermonengine.game.update.sit;

import com.millar.ermonengine.controller.model.game.SitRequest;
import com.millar.ermonengine.controller.model.game.SitResponse;
import com.millar.ermonengine.dao.model.Game;
import com.millar.ermonengine.dao.model.TableId;
import com.millar.ermonengine.game.update.UpdateGame;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SeatManager {
    private final UpdateGame updateGame;

    public SitResponse sit(SitRequest request) {
        Game game;
        if(SitAction.SIT_IN.equals(request.getSitAction())) {
            //TODO
            game = updateGame.addPlayer(new TableId(request.getTableName(), request.getGameId()), request.getPlayer(),
                    request.getBuyIn());
        } else {
            game = updateGame.sitPlayerOut(new TableId(request.getTableName(), request.getGameId()), request.getPlayer().getPlayerId());
        }
        //TODO
        return new SitResponse();
    }
}

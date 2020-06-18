package com.millar.ermonengine.game.player;

import com.millar.ermonengine.controller.model.PlayerRequest;
import com.millar.ermonengine.dao.model.Game;
import com.millar.ermonengine.dao.model.Player;
import com.millar.ermonengine.game.PlayerStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

//TODO: rename class
@Slf4j
@Service
public class PlayerList {

    public Optional<Player> getExistingMaybe(Game game, String playerId) {
        return game.getPlayerList().stream()
                .filter(p -> playerId.equalsIgnoreCase(p.getPlayerId()))
                .findFirst();
    }

    public Player addNewPlayer(PlayerRequest playerRequest, BigDecimal buyIn) {
        //TODO: validate buyin
        if(true) {
            return new Player(
                    playerRequest.getPlayerId(),
                    playerRequest.getAlias(),
                    buyIn,
                    PlayerStatus.SEATED
            );
        } else {
            //TODO:throw exception and return default value if exists
            log.error("Invalid buy-in");
            throw new RuntimeException();
        }
    }
}

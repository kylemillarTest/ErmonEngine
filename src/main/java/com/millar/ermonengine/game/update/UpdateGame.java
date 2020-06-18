package com.millar.ermonengine.game.update;

import com.millar.ermonengine.controller.model.PlayerRequest;
import com.millar.ermonengine.dao.model.Game;
import com.millar.ermonengine.dao.model.Player;
import com.millar.ermonengine.dao.model.TableId;
import com.millar.ermonengine.game.GameService;
import com.millar.ermonengine.game.PlayerStatus;
import com.millar.ermonengine.game.player.PlayerList;
import com.millar.ermonengine.game.player.update.UpdatePlayer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UpdateGame {
    private final GameService gameService;
    private final PlayerList playerList;
    private final UpdatePlayer updatePlayer;

    public Game addPlayer(TableId tableId, PlayerRequest player, BigDecimal buyIn) {
        Game game = gameService.getGame(tableId);
        return addPlayer(game, player, buyIn);
    }

    public Game addPlayer(Game game, PlayerRequest playerRequest, BigDecimal buyIn) {
        //TODO: is sit-in allowed?

        Player player = playerList.getExistingMaybe(game, playerRequest.getPlayerId())
                .map(p -> updatePlayer.update(p, PlayerStatus.SEATED))
                .orElse(playerList.addNewPlayer(playerRequest, buyIn));

        //TODO: should not always do this
        return gameService.addPlayer(game, player);
    }

    public Game sitPlayerOut(TableId tableId, String playerId) {
        Game game = gameService.getGame(tableId);
        return sitPlayerOut(game, playerId);
    }

    public Game sitPlayerOut(Game game, String playerId) {
        Player player = updatePlayer.sitout(game, playerId);
        return gameService.updatePlayer(game, player);
    }
}

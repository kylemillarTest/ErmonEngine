package com.millar.ermonengine.game.player.update;

import com.millar.ermonengine.dao.model.Game;
import com.millar.ermonengine.dao.model.Player;
import com.millar.ermonengine.game.PlayerStatus;
import com.millar.ermonengine.game.player.PlayerList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePlayer {
    private final PlayerList playerList;

    public Player update(Player player, PlayerStatus playerStatus) {
        player.setStatus(playerStatus);
        return player;
    }

    public Player sitout(Game game, String playerId) {
        return playerList.getExistingMaybe(game, playerId)
                .map(p -> update(p, PlayerStatus.OUT))
                //TODO
                .orElseThrow();
    }
}

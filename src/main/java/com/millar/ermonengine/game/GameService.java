package com.millar.ermonengine.game;

import com.millar.ermonengine.dao.model.Game;
import com.millar.ermonengine.dao.model.Player;
import com.millar.ermonengine.dao.model.TableId;
import com.millar.ermonengine.dao.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GameService {

    private final GameRepository gameRepository;

    public Game getGame(TableId tableId) {
        return gameRepository.findById(tableId)
                .orElseThrow();
    }

    public Game createGame(TableId tableId) {
        Game game = new Game(
                new TableId(tableId, UUID.randomUUID().toString()),
                GameStatus.WAITING
        );
        return gameRepository.save(game);
    }

    public Game addPlayer(Game game, Player player) {
        List<Player> playerList = game.getPlayerList();
        if(playerList.stream().noneMatch(p -> player.getPlayerId().equalsIgnoreCase(p.getPlayerId()))) {
            playerList.add(player);
        } else {
            //TODO
            throw new RuntimeException();
        }
        game.setPlayerList(playerList);
        return gameRepository.save(game);
    }

    public Game updatePlayer(Game game, Player player) {
        List<Player> updatedPlayerList = game.getPlayerList().stream()
                .map(p -> p.getPlayerId().equals(player.getPlayerId()) ? player : p)
                .collect(Collectors.toList());
        game.setPlayerList(updatedPlayerList);
        return gameRepository.save(game);
    }
}

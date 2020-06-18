package com.millar.ermonengine.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GameStatus {
    WAITING,
    PREFLOP,
    FLOP,
    TURN,
    RIVER,
    SHOW,
    CLOSED
}

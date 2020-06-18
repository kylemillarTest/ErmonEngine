package com.millar.ermonengine.controller.model.game;

import com.millar.ermonengine.controller.model.PlayerRequest;
import com.millar.ermonengine.game.update.sit.SitAction;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class SitRequest {
    @NotEmpty
    private final String tableName;
    @NotEmpty
    private final String gameId;
    @NotNull
    private PlayerRequest player;
    @NotNull
    private SitAction sitAction;
    @Positive
    private BigDecimal buyIn;
}

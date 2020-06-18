package com.millar.ermonengine.controller.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PlayerRequest {
    @NotEmpty
    private final String playerId;
    private String alias;
}

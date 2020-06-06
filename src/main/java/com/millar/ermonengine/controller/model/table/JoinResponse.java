package com.millar.ermonengine.controller.model.table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class JoinResponse {
    private final String tableName;
    private final String tableOwner;
    private final UUID gameId;
    private final boolean triggeredGameCreation;
    private Instant gameCreatedAt;
}

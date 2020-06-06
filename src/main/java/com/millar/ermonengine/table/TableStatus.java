package com.millar.ermonengine.table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum TableStatus {
    OPEN,
    CLOSED,
    ACTIVE;

    public static TableStatus fromString(String value) {
        return Stream.of(TableStatus.values())
                .filter(status -> value.equalsIgnoreCase(status.toString()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}

package com.millar.ermonengine.table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TableStatus {
    OPEN,
    CLOSED,
    ACTIVE
}

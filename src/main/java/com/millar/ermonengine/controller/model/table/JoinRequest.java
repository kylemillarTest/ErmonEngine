package com.millar.ermonengine.controller.model.table;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class JoinRequest {
    @NotEmpty
    private final String name;
    @NotEmpty
    private final String owner;
    @NotEmpty
    private final String userName;
    private String nameAtTable;
}

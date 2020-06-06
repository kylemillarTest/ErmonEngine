package com.millar.ermonengine.controller.model.table;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateTableRequest {
    @NotEmpty
    private final String name;
    @NotEmpty
    private final String owner;
    //TODO: fix this
//    List<String> adminList;
    private final String ruleSet;
}

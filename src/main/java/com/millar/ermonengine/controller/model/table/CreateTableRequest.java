package com.millar.ermonengine.controller.model.table;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateTableRequest {
    @NotEmpty
    private final String tableName;
    @NotEmpty
    private final String tableOwner;
    //TODO: fix this
//    List<String> adminList;
    private final String ruleSet;
}

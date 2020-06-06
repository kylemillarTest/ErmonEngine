package com.millar.ermonengine.controller.model.table;

import com.millar.ermonengine.dao.model.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class JoinRequest {
    @NotNull
    @Valid
    private final TableId tableId;
    @NotEmpty
    private final String userName;
    private String nameAtTable;
}

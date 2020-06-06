package com.millar.ermonengine.table.create;

import com.millar.ermonengine.controller.model.table.CreateTableRequest;
import com.millar.ermonengine.controller.model.table.CreateTableResponse;
import com.millar.ermonengine.dao.model.Table;
import com.millar.ermonengine.table.TableService;
import com.millar.ermonengine.table.TableStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateTableService {

    private final TableService tableService;

    public CreateTableResponse createTable(CreateTableRequest request) {
        log.info("Creating table... {}", request.getName());

        Table table = tableService.createTable(request.getName(), request.getOwner(), request.getRuleSet());

        log.info("Table created.");
        return new CreateTableResponse(table.getName(), table.getOwner(), table.getRuleSet(), table.getCreatedAt(), TableStatus.fromString(table.getStatus()));
    }
}

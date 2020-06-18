package com.millar.ermonengine.table;

import com.millar.ermonengine.dao.model.Table;
import com.millar.ermonengine.dao.model.TableId;
import com.millar.ermonengine.dao.repository.TableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class TableService {

    private final TableRepository tableRepository;

    public Table getTable(TableId tableId) {
        //TODO: fix error handling
        return tableRepository.findById(tableId)
                .orElseThrow(RuntimeException::new);
    }

    public Table createTable(String name, String owner, String ruleSet) {
        Table table = new Table(
                new TableId(name, owner),
                ruleSet,
                Instant.now(),
                TableStatus.OPEN
        );
        return tableRepository.save(table);
    }
}

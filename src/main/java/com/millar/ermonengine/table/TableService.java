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

//    public Table createTable(String name, String owner, boolean isPublic, List<String> adminList, String ruleSet) {
//        Table table = new Table(
//            new TableId(name, owner),
//            isPublic,
//            adminList,
//            ruleSet,
//            Instant.now(),
//            TableStatus.OPEN.toString()
//        );
//        return tableRepository.save(table);
//    }

    public Table createTable(String name, String owner, String ruleSet) {
        Table table = new Table(
                new TableId(name, owner),
                ruleSet,
                Instant.now(),
                TableStatus.OPEN.toString()
        );
        return tableRepository.save(table);
    }
}

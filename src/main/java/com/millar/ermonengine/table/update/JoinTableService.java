package com.millar.ermonengine.table.update;

import com.millar.ermonengine.controller.model.table.CreateTableResponse;
import com.millar.ermonengine.controller.model.table.JoinRequest;
import com.millar.ermonengine.controller.model.table.JoinResponse;
import com.millar.ermonengine.dao.model.Table;
import com.millar.ermonengine.table.TableService;
import com.millar.ermonengine.table.TableStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class JoinTableService {

    private final TableService tableService;

//    public JoinResponse joinTable(JoinRequest request) {
//        log.info("{} is joining table {}", request.getUserName(), request.getTableId());
//        Game game = gameService.getGame(request.getTableId());
//
//        log.info("Table joined");
//        return new JoinResponse()
//    }
}

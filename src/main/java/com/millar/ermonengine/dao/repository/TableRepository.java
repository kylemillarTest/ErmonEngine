package com.millar.ermonengine.dao.repository;

import com.millar.ermonengine.dao.model.Table;
import com.millar.ermonengine.dao.model.TableId;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface TableRepository extends CrudRepository<Table, TableId> {
}

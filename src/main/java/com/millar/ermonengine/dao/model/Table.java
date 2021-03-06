package com.millar.ermonengine.dao.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.millar.ermonengine.dao.converters.InstantConverter;
import com.millar.ermonengine.table.TableStatus;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;

//TODO: rename this table to be more inclusive
@DynamoDBTable(tableName = "Table")
@Setter
@NoArgsConstructor
public class Table {
    private static final String DELIMITER = "#";

    @Id
    private TableId tableId;
    //List<String> adminList;
    //filler
    private String ruleSet;
    private Instant createdAt;
    private Instant lastPlayedAt;
    private TableStatus status;

    public Table(TableId tableId, String ruleSet, Instant createdAt, TableStatus status) {
        this.tableId = tableId;
        this.ruleSet = ruleSet;
        this.createdAt = createdAt;
        this.status = status;
    }

    //spring data will not like it if we have the get for the key
    @DynamoDBIgnore
    //TODO: wont need this when get requests are formalized
    @JsonIgnore
    public TableId getTableId() {
        return tableId;
    }

    //--Used to define key of multiple fields for spring data-----------
    @DynamoDBHashKey(attributeName = "PK")
    public String getPK() {
        return tableId != null ? tableId.getPK() : null;
    }

    public void setPK(String PK) {
        if(tableId == null) {
            tableId = new TableId();
        }
        tableId.setPK(PK);
    }

    @DynamoDBRangeKey(attributeName = "SK")
    public String getSK() {
        return tableId != null ? tableId.getSK() : null;
    }

    public void setSK(String SK) {
        if(tableId == null) {
            tableId = new TableId();
        }
        tableId.setSK(SK);
    }

    //-----------------------------------

//    @DynamoDBAttribute
//    public List<String> getAdminList() {
//        return adminList;
//    }

    @DynamoDBAttribute
    public String getRuleSet() {
        return ruleSet;
    }

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute
    public TableStatus getStatus() {
        return status;
    }

    @DynamoDBTypeConverted(converter = InstantConverter.class)
    @DynamoDBAttribute
    public Instant getCreatedAt() {
        return createdAt;
    }

    @DynamoDBTypeConverted(converter = InstantConverter.class)
    @DynamoDBAttribute
    public Instant getLastPlayedAt() {
        return lastPlayedAt;
    }

    //used to get the values we want from the composite hash key
    @DynamoDBIgnore
    public String getName() {
        return getPK() != null ? getPK().split(DELIMITER)[2] : null;
    }

    @DynamoDBIgnore
    public String getOwner() {
        return getPK() != null ? getPK().split(DELIMITER)[3] : null;
    }
}

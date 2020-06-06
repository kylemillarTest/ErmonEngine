package com.millar.ermonengine.dao.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.millar.ermonengine.dao.converters.InstantConverter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;

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
    private String status;

//    public Table(TableId tableId, boolean isPublic, List<String> adminList, String ruleSet, Instant createdAt, String status) {
//        this.tableId = tableId;
//        this.isPublic = isPublic;
//        this.adminList = adminList;
//        this.ruleSet = ruleSet;
//        this.createdAt = createdAt;
//        this.status = status;
//    }

    public Table(TableId tableId, String ruleSet, Instant createdAt, String status) {
        this.tableId = tableId;
        this.ruleSet = ruleSet;
        this.createdAt = createdAt;
        this.status = status;
    }

    @DynamoDBIgnore
    public String getName() {
        return getPK() != null ? getPK().split(DELIMITER)[2] : null;
    }

    @DynamoDBIgnore
    public String getOwner() {
        return getPK() != null ? getPK().split(DELIMITER)[3] : null;
    }

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

//    @DynamoDBAttribute
//    public List<String> getAdminList() {
//        return adminList;
//    }

    @DynamoDBAttribute
    public String getRuleSet() {
        return ruleSet;
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

    @DynamoDBAttribute
    public String getStatus() {
        return status;
    }
}

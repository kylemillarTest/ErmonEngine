package com.millar.ermonengine.dao.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import java.util.UUID;

//TODO: rename this class to be more inclusive
public class TableId {
    private static final String TABLE = "#TABLE#";
    private static final String GAME = "#GAME#";
    private static final String DELIMITER = "#";

    private String PK;
    private String SK;

    protected TableId() {
        //used solely for setter in classes that use TableId
    }

    //table
    public TableId(String name, String owner) {
        this.PK = buildKeyName(TABLE, name, owner);
        this.SK = PK;
    }

    //used for same PK but different SK
    public TableId(TableId tableId, String SK) {
        this.PK = tableId.getPK();
        this.SK = buildKeyName(GAME, SK);
    }

    @DynamoDBHashKey
    public String getPK() {
        return PK;
    }

    protected void setPK(String PK) {
        this.PK = PK;
    }

    @DynamoDBRangeKey
    public String getSK() {
        return SK;
    }

    protected void setSK(String SK) {
        this.SK = SK;
    }

    //helper methods to work with key identifiers and composite keys
    private String buildKeyName(String identifier, String key1) {
        return identifier +key1;
    }

    private String buildKeyName(String identifier, String key1, String key2) {
        return buildKeyName(identifier, key1) +DELIMITER +key2;
    }

    public static String toString(String name, String owner) {
        return name + "-" + owner;
    }
}

package com.millar.ermonengine.dao.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.millar.ermonengine.dao.converters.InstantConverter;
import com.millar.ermonengine.game.GameStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.List;

@DynamoDBTable(tableName = "Table")
@Setter
@NoArgsConstructor
public class Game {
    private static final String DELIMITER = "#";

    @Id
    private TableId tableId;
    private List<Player> playerList;
    private GameStatus status;
    private Instant createdAt;
    private Instant lastPlayedAt;

    public Game(TableId tableId, GameStatus status) {
         this.tableId = tableId;
         this.status = status;
         this.createdAt = Instant.now();
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

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.L)
    @DynamoDBAttribute
    public List<Player> getPlayerList() {
        return playerList;
    }

    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute
    public GameStatus getStatus() {
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

    //get the value we want from the sort key
    @DynamoDBIgnore
    public String getGameId() {return getSK() != null ? getSK().split(DELIMITER)[2] : null; }
}

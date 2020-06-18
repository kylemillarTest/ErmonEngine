package com.millar.ermonengine.dao.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.millar.ermonengine.game.PlayerStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    @DynamoDBAttribute
    private String playerId;
    @DynamoDBAttribute
    private String alias;
    @DynamoDBAttribute
    private BigDecimal stack;
    //TODO
    //private PlayerHand cards;
    @DynamoDBTypeConvertedEnum
    @DynamoDBAttribute
    private PlayerStatus status;
}

package com.millar.ermonengine.dao.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.Instant;

public class InstantConverter implements DynamoDBTypeConverter<String, Instant> {
    @Override
    public String convert(Instant ins) {
        return ins.toString();
    }

    @Override
    public Instant unconvert(String str) {
        return Instant.parse(str);
    }
}

package com.millar.ermonengine.config.aws;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableDynamoDBRepositories(
        basePackages = "com.millar.ermonengine.dao.repository"
)
public class DynamoConfig {

    @Bean("amazonDynamoDB")
    @Profile("!local")
    public AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClient.builder().build();
    }

    //TODO: is this required?
    @Bean("amazonDynamoDB")
    @Profile("local")
    public AmazonDynamoDB amazonDynamoDBLocal() {
        return AmazonDynamoDBClient.builder()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "ddblocal")
                )
                .build();
    }
}

package com.quip.Quip_AEM_extract.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoClientConfig {

    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create();
    }
}
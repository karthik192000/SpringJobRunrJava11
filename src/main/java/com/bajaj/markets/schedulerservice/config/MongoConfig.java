package com.bajaj.markets.schedulerservice.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.UuidRepresentation;
import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.storage.nosql.mongo.MongoDBStorageProvider;
import org.jobrunr.utils.mapper.jackson.JacksonJsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {



    @Bean(name = "mongoClient")
    public MongoClient mongoClient(){
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/jobrunr");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .build();
        return MongoClients.create(mongoClientSettings);
    }


    @Override
    protected String getDatabaseName() {
        return "jobrunr";
    }


    @Bean(name = "jobMapper")
    public JobMapper jobMapper(){
        return new JobMapper(new JacksonJsonMapper());
    }

    @Bean
    @Primary
    public MongoDBStorageProvider mongoDBStorageProvider(MongoClient mongoClient, JobMapper jobMapper){
        MongoDBStorageProvider mongoDBStorageProvider = new MongoDBStorageProvider(mongoClient);
        mongoDBStorageProvider.setJobMapper(jobMapper);
        return mongoDBStorageProvider;
    }
}

package com.zipte.infrastructure.out.persistence.repository.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "com.zipte", //해당 패키지 안에 몽고 레포지토리는 아래 템플릿의 영향을 받는다.
        mongoTemplateRef = MongoTemplateConfig.MONGO_TEMPLATE
)
public class MongoTemplateConfig {

    public static final String MONGO_TEMPLATE = "notificationMongoTemplate";

    @Bean(name = MONGO_TEMPLATE)
    public MongoTemplate notificationMongoTemplate(
            MongoDatabaseFactory notificationMongoFactory,
            MongoConverter mongoConverter
    ) {
        return new MongoTemplate(notificationMongoFactory, mongoConverter);
    }
}

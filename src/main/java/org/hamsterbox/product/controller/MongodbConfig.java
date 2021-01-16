package org.hamsterbox.product.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.bson.types.ObjectId;
import org.hamsterbox.product.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * AppConfig
 */
@Configuration
// @EnableMongoRepositories
public class MongodbConfig extends AbstractMongoClientConfiguration {
  private String database = "todo";

  @Bean
  public MongoClient mongoClient() {
    String uri = new String("mongodb+srv://tiktzuki:123@cluster0.zofmi.mongodb.net/todo?retryWrites=true&w=majority");
    return MongoClients.create(uri);
  }

  @Bean
  public MongoTemplate mongoTemplate() {
    return new MongoTemplate(mongoClient(), this.database);
  }

  @Override
  protected String getDatabaseName() {
    return this.database;
  }
}

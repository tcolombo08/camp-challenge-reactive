package com.campgladiator.trainers;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@EnableMongoAuditing
@SpringBootApplication
public class TrainerApiApplication {
  public static void main(String[] args) {
    SpringApplication.run(TrainerApiApplication.class, args);
  }
}

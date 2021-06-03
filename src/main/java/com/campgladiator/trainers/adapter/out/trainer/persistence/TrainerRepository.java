package com.campgladiator.trainers.adapter.out.trainer.persistence;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TrainerRepository extends ReactiveMongoRepository<Trainer, String> {
}

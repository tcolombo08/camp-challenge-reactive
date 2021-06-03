package com.campgladiator.trainers.domain.trainer.port.out.persistence;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QueryTrainerPort {

  Mono<Trainer> findById(String trainerId);

  Flux<Trainer> findAll();
}

package com.campgladiator.trainers.domain.trainer.port.out.persistence;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import reactor.core.publisher.Mono;

public interface CreateTrainerPort {

  Mono<Trainer> create(Trainer trainer);
}

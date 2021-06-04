package com.campgladiator.trainers.domain.trainer.usecase;

import static org.springframework.util.Assert.notNull;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.QueryTrainerPort;
import com.campgladiator.trainers.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
@RequiredArgsConstructor
public class ListTrainersUseCase {
  private final QueryTrainerPort queryTrainerPort;

  public Flux<Trainer> findAll () {
    return queryTrainerPort.findAll()
        .switchIfEmpty( Mono.error(new EntityNotFoundException()));
  }
}

package com.campgladiator.trainers.adapter.out.trainer.persistence;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.CreateTrainerPort;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.QueryTrainerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class TrainerPersistenceAdapter implements QueryTrainerPort, CreateTrainerPort {

  private TrainerRepository trainerRepository;

  @Override
  public Mono<Trainer> create(Trainer trainer) {
    return trainerRepository.save(trainer);
  }

  @Override
  public Mono<Trainer> findById(String trainerId) {
    return trainerRepository.findById(trainerId);
  }

  @Override
  public Flux<Trainer> findAll() {
    return trainerRepository.findAll();
  }
}

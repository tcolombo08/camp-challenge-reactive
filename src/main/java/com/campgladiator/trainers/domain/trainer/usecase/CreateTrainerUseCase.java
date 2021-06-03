package com.campgladiator.trainers.domain.trainer.usecase;

import static org.springframework.util.Assert.*;

import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.port.out.persistence.CreateTrainerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateTrainerUseCase {

  private final CreateTrainerPort createTrainerPort;

  public Mono<Trainer> create(final TrainerCreationRequest trainerCreationRequest) {
    notNull(trainerCreationRequest, "trainerCreationRequest cannot be null");
    final Trainer trainer = Trainer.builder().email(trainerCreationRequest.getEmail())
        .phone(trainerCreationRequest.getPhone()).firstName(trainerCreationRequest.getFirstName())
        .lastName(trainerCreationRequest.getLastName()).build();
    return createTrainerPort.create(trainer);
  }
}

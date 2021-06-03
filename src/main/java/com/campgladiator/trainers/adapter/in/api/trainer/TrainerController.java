package com.campgladiator.trainers.adapter.in.api.trainer;

import static com.campgladiator.trainers.adapter.in.api.trainer.TrainerController.PATH;

import com.campgladiator.trainers.adapter.in.api.trainer.model.TrainerCreationRequestDTO;
import com.campgladiator.trainers.adapter.in.api.trainer.model.TrainerCreationRequestMapper;
import com.campgladiator.trainers.adapter.out.trainer.model.TrainerDtoMapper;
import com.campgladiator.trainers.domain.trainer.model.Trainer;
import com.campgladiator.trainers.domain.trainer.usecase.CreateTrainerUseCase;
import com.campgladiator.trainers.domain.trainer.usecase.TrainerCreationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping(value = PATH)
@RequiredArgsConstructor
public class TrainerController {

  static final String PATH = "/api/v1/camp/trainer";
  private final CreateTrainerUseCase createTrainerUseCase;
  private final TrainerCreationRequestMapper trainerCreationRequestMapper;
  private final TrainerDtoMapper trainerDtoMapper;

  @PostMapping
  public void create(final TrainerCreationRequestDTO creationRequestDto) {
    log.debug("Creating a Trainer... '{}'", () -> creationRequestDto);

    final TrainerCreationRequest creationRequest =
        trainerCreationRequestMapper.map(creationRequestDto);
    Mono<Trainer> trainerMono = createTrainerUseCase.create(creationRequest);


        trainerMono.subscribe(
            trainer -> {
              log.info(
                  "Successfully created a trainer with id={} and email={}.",
                  trainer.getId(),
                  trainer.getEmail());
              Mono.just(trainerDtoMapper.map(trainer));
            });
  }
}

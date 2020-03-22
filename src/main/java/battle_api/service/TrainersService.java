package battle_api.service;

import battle_api.bo.Trainer;
import battle_api.dto.TrainerWithPokemonDto;

import java.util.List;

public interface TrainersService {
    List<Trainer> listTrainer();
    TrainerWithPokemonDto getTrainerWithPokemonDto(String name);
    Trainer getTrainer(String name);
    Trainer[] getAllTrainers();
}

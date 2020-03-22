package battle_api.converter;
import battle_api.bo.BattlePokemon;
import battle_api.bo.BattleTrainer;
import battle_api.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainerConverter {
    @Autowired
    private PokemonConverter pokemonConverter;
    public BattleTrainer trainerToBattleTrainer(Trainer trainer) {
        List<BattlePokemon> team=trainer.getTeam().stream().map(pokemon -> pokemonConverter.PokemonToBattlePokemon(pokemon)).collect(Collectors.toList());
        return new BattleTrainer(trainer.getName(),false,team);
    }
}

package battle_api.dto;
import battle_api.bo.Trainer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainerWithPokemonDto {
    private Trainer trainer;
    private List<PokemonDto> team;

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<PokemonDto> getTeam() {
        return team;
    }

    public void setTeam(List<PokemonDto> team) {
        this.team = team;
    }
}

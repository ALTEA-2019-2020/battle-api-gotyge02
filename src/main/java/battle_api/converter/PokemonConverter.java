package battle_api.converter;

import battle_api.bo.BattlePokemon;
import battle_api.bo.Pokemon;
import battle_api.bo.PokemonType;
import battle_api.service.PokemonTypeServiceImpl;
import battle_api.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonConverter {
    @Autowired
    private PokemonTypeServiceImpl pokemonTypeService;
    public BattlePokemon PokemonToBattlePokemon(Pokemon pokemon){
        PokemonType pokemonType = pokemonTypeService.getPokemon(pokemon.getPokemonTypeId());
        return new BattlePokemon(true,false,pokemon.getLevel(),pokemonType,
                Utils.calculateHP(pokemonType.getStats().getHp(),pokemon.getLevel()),
                Utils.calculateStat(pokemonType.getStats().getAttack(),pokemon.getLevel()),
                Utils.calculateStat(pokemonType.getStats().getDefense(),pokemon.getLevel()),
                Utils.calculateStat(pokemonType.getStats().getSpeed(),pokemon.getLevel()),
                Utils.calculateHP(pokemonType.getStats().getHp(),pokemon.getLevel()),
                Utils.getNext());
    }
}

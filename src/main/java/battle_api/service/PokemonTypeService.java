package battle_api.service;

import battle_api.bo.PokemonType;

import java.util.List;

public interface PokemonTypeService {
    List<PokemonType> listPokemonsTypes();
    List<PokemonType> listPokemonsTypes(List<Integer> id);
}
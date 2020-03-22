package battle_api.bo;

public class BattlePokemonFactory {

    private PokemonType pokemonType;
    private int level;

    public BattlePokemonFactory(PokemonType pokemonType, int level) {
        this.pokemonType = pokemonType;
        this.level = level;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

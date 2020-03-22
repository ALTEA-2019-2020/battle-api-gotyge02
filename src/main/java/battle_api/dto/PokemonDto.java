package battle_api.dto;
import battle_api.bo.PokemonType;
import battle_api.bo.Sprites;
import battle_api.bo.Stats;

import java.util.List;

public class PokemonDto {

    private String name;
    private int level;
    private int id;
    private int baseExperience;
    private int height;
    private Sprites sprites;
    private Stats stats;
    private int weight;
    private List<String> types;

    public PokemonDto(String name, int level, int id, int baseExperience, int height, Sprites sprites, Stats stats, int weight, List<String> types) {
        this.name = name;
        this.level = level;
        this.id = id;
        this.baseExperience = baseExperience;
        this.height = height;
        this.sprites = sprites;
        this.stats = stats;
        this.weight = weight;
        this.types = types;
    }

    public PokemonDto(int level, PokemonType pokemonType) {
        this.level = level;
        this.id = pokemonType.getId();
        this.baseExperience = pokemonType.getBaseExperience();
        this.height = pokemonType.getHeight();
        this.name = pokemonType.getName();
        this.sprites = pokemonType.getSprites();
        this.stats = pokemonType.getStats();
        this.weight = pokemonType.getWeight();
        this.types = pokemonType.getTypes();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}

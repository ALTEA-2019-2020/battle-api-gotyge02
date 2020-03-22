package battle_api.bo;
import java.util.List;

public class BattleTrainer {
    private String name;
    private List<BattlePokemon> team;
    private int currentPokemon;
    private boolean haveSomePokemonAlive;
    private boolean nextTurn;

    public BattleTrainer(String name, boolean nextTurn, List<BattlePokemon> team) {
        this.name=name;
        this.nextTurn=nextTurn;
        this.team=team;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTeam(List<BattlePokemon> team) {
        this.team = team;
    }
    public List<BattlePokemon> getTeam(){
        return this.team;
    }
    public boolean isNextTurn() {
        return nextTurn;
    }
    public void setNextTurn(boolean nextTurn) {
        this.nextTurn = nextTurn;
    }
    public int getCurrentPokemon() {
        return currentPokemon;
    }
    public void setCurrentPokemon(int currentPokemon) {
        this.currentPokemon = currentPokemon;
    }
    public void increaseCurrentPokemon(){
        this.currentPokemon = this.currentPokemon + 1;
    }
    public boolean isHaveSomePokemonAlive() {
        return haveSomePokemonAlive;
    }
    public void setHaveSomePokemonAlive(boolean haveSomePokemonAlive) {
        this.haveSomePokemonAlive = haveSomePokemonAlive;
    }
    public boolean updateTeamAlive(){
        if(this.getTeam().size()<=this.currentPokemon){this.haveSomePokemonAlive = false;}
        else{this.haveSomePokemonAlive = true;}
        return this.haveSomePokemonAlive;
    }
}

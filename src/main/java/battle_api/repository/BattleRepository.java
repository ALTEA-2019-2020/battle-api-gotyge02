package battle_api.repository;
import battle_api.bo.Battle;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BattleRepository {
    private static final BattleRepository INSTANCE = new BattleRepository();
    @Autowired
    private Map<String, Battle> battles;
    public BattleRepository(){
        this.battles = new HashMap<>();
    }
    public static BattleRepository getInstance() {
        return INSTANCE;
    }
    public Battle getBattle(String uuid){
        return battles.get(uuid);
    }
    public void addBattle(Battle battle){
        this.battles.put(battle.getUuid(), battle);
    }
    public void deleteBattle(String uuid){
        this.battles.remove(uuid);
    }
    public List<Battle> getAllBattle(){
        return this.battles.values().stream().collect(Collectors.toList());
    }
}

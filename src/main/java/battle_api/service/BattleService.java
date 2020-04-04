package battle_api.service;
import battle_api.bo.Battle;
import java.util.List;

public interface BattleService {
    String createBattle(String trainerName1, String trainerName2);
    List<Battle> getAllBattle();
    Battle getBattle(String uuid);
    Battle attack(String uuid, String trainerName) throws Exception;
}

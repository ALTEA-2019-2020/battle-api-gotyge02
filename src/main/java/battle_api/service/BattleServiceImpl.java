package battle_api.service;
import battle_api.bo.Battle;
import battle_api.bo.BattlePokemon;
import battle_api.bo.BattleTrainer;
import battle_api.converter.TrainerConverter;
import battle_api.repository.BattleRepository;
import battle_api.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BattleServiceImpl implements BattleService {
    public TrainersServiceImpl trainersService;
    public BattleRepository battleRepository;
    private TrainerConverter trainerConverter;
    @Autowired
    public BattleServiceImpl(TrainersServiceImpl trainersService, TrainerConverter trainerConverter) {
        this.trainersService = trainersService;
        this.trainerConverter = trainerConverter;
        this.battleRepository = BattleRepository.getInstance();
    }
    @Override
    public String createBattle(String trainerName, String opponentName) {
        BattleTrainer trainer = trainerConverter.trainerToBattleTrainer(trainersService.getTrainer(trainerName));
        BattleTrainer opponent = trainerConverter.trainerToBattleTrainer(trainersService.getTrainer(opponentName));
        this.setFirstPlayer(trainer,opponent);
        String uuid = UUID.randomUUID().toString();
        Battle battle = new Battle(trainer, opponent, uuid);
        this.battleRepository.addBattle(battle);
        return uuid;
    }
    private void setFirstPlayer(BattleTrainer trainer, BattleTrainer opponent) {
        if(trainer.getTeam().get(0).getSpeed()>=opponent.getTeam().get(0).getSpeed()){
            trainer.setNextTurn(true);
            opponent.setNextTurn(false);
        }
        else{
            opponent.setNextTurn(true);
            trainer.setNextTurn(false);
        }
    }

    @Override
    public List<Battle> getAllBattle() {
        return this.battleRepository.getAllBattle();
    }

    @Override
    public Battle getBattle(String uuid) {
        return this.battleRepository.getBattle(uuid);
    }

    @Override
    public Battle attack(String uuid, String trainerName) {
        Battle battle = this.getBattle(uuid);
        int val = checkTrainerRound(battle,trainerName);
        BattleTrainer battletrainer = this.checkIfTrainersHaveAPokemonAliveToFight(battle);
        if(val%2== 1){
            if(val == 1){doAttackRound(battle.getOpponent(), battle.getTrainer());}
            else if(val == 3){doAttackRound(battle.getTrainer(), battle.getOpponent());}
        }
        checkIfTrainersHaveAPokemonAliveToFight(battle);
        return battle;
    }

    private BattleTrainer checkIfTrainersHaveAPokemonAliveToFight(Battle battle){
        if(!battle.getTrainer().updateTeamAlive())return battle.getTrainer();
        if(!battle.getOpponent().updateTeamAlive())return battle.getOpponent();
        return null;
    }

    private int checkTrainerRound(Battle battle, String trainerName){
        if(battle.getOpponent().getName().equals(trainerName) ){
            if(battle.getOpponent().isNextTurn()){ return 1;}else return 2;
        }
        if(battle.getTrainer().getName().equals(trainerName) ){
            if(battle.getTrainer().isNextTurn()){ return 3;}else return 4;
        }
        return 0;
    }

    private void setNextRound(BattleTrainer attackerTrainer, BattleTrainer defenderTrainer) {
        attackerTrainer.setNextTurn(!attackerTrainer.isNextTurn());
        defenderTrainer.setNextTurn(!defenderTrainer.isNextTurn());
    }

    private void doAttackRound(BattleTrainer attackerTrainer, BattleTrainer defenderTrainer) {
        dealDamage(attackerTrainer, defenderTrainer);
        setNextRound(attackerTrainer, defenderTrainer);
    }

    private void dealDamage(BattleTrainer attackerTrainer, BattleTrainer defenderTrainer){
        BattlePokemon attackerPokemon = attackerTrainer.getTeam().get(attackerTrainer.getCurrentPokemon());
        BattlePokemon defenderPokemon = defenderTrainer.getTeam().get(defenderTrainer.getCurrentPokemon());
        if(!defenderPokemon.takeDamages(Utils.calculateDamage(attackerPokemon, defenderPokemon)))
            defenderTrainer.increaseCurrentPokemon();
    }


}

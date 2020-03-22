package battle_api.controller;

import battle_api.bo.Battle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import battle_api.service.BattleServiceImpl;

@Controller
@RequestMapping(value = "/battles")
public class BattleController {
    private BattleServiceImpl battleService;
    @Autowired
    public BattleController(BattleServiceImpl battleService) {
        this.battleService = battleService;
    }
    @PostMapping()
    public ResponseEntity<String> battles(@RequestBody Map<String, String> body) {
        String trainerName = body.get("trainerName");
        String opponentName = body.get("opponentName");
        return ResponseEntity.ok().body(this.battleService.createBattle(trainerName, opponentName));
    }
    @GetMapping(value = "/{uuid}")
    public ResponseEntity<Battle> getBattle(@PathVariable(value = "uuid")String uuid){
        return ResponseEntity.ok().body(this.battleService.getBattle(uuid));
    }
    @GetMapping()
    public ResponseEntity<List<Battle>> getAllBattles() {
        return ResponseEntity.ok().body(this.battleService.getAllBattle());
    }
    @PostMapping(value = "/{uuid}/{trainerName}/attack")
    public ResponseEntity<Battle> attack(@PathVariable(value = "uuid") String uuid, @PathVariable(value = "trainerName") String trainerName){
        return ResponseEntity.ok().body(this.battleService.attack(uuid, trainerName));
    }
}

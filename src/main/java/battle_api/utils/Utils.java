package battle_api.utils;

import battle_api.bo.BattlePokemon;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Math.round;

public class Utils {
    private static AtomicLong value = new AtomicLong(1);
    public static int getNext() {
        return (int) value.getAndIncrement();
    }
    //se réfère à la RG de l'énoncé
    public static int calculateHP(int stat, int lvl){
        return (int) (10.00+Double.valueOf(lvl)+(Double.valueOf(stat)*(Double.valueOf(lvl)/50.00)));
    }
    //se réfère à la RG de l'énoncé
    public static int calculateStat(int stat, int lvl){
        return (int) (5.00+(Double.valueOf(stat)*(Double.valueOf(lvl)/50.00)));
    }
    //se réfère à la RG de l'énoncé
    public static int calculateDamage(BattlePokemon attacker, BattlePokemon defend){
        return (int) round((((2.00*Double.valueOf(attacker.getLevel()))/5.00)+(2.00*(Double.valueOf(attacker.getAttack())/Double.valueOf(defend.getDefence()))))+2.00);
    }
}

package Player;

import Enemy.Enemy;
import Tile.Unit;

public class Warrior extends Player{
    private int remainingCooldown;
    private int abilityCooldown;
    protected static final int SPECIAL_ABILITY_BONUS = 10;
    protected static final int EXTRA_HEALTH_BONUS = 5;
    protected static final int EXTRA_ATTACK_BONUS = 2;
    protected static final int EXTRA_DEFENSE_BONUS = 1;
    protected static final int RANGE = 3;


    protected Warrior(String name, int healthCapacity, int attack, int defense,int abilityCooldown) {
        super(name, healthCapacity, attack, defense);
        this.remainingCooldown = 0;
        this.abilityCooldown = abilityCooldown;
    }

    public void AvengerShield(Enemy enemy){
        if(remainingCooldown==0) {
            remainingCooldown=abilityCooldown;
            if (position.range(enemy.getPosition()) < RANGE) {
            }
        }
    }
    public void addExperience(int experienceGained){
        experience=experience+experienceGained;
        while (this.experience>=levelUpRequirement()){
            super.addExperience(experienceGained);
            remainingCooldown = 0;
            setHealth(getHealth().getHealthCapacity() + gainExtraHealth());
            setAttack(getAttack() + gainExtraAttack());
            setDefense(getDefense() + gainExtraDefense());
        }
    }

    protected int gainExtraHealth(){
        return level * EXTRA_HEALTH_BONUS;
    }
    protected int gainExtraAttack(){
        return level * EXTRA_ATTACK_BONUS;
    }
    protected int gainExtraDefense(){
        return level * EXTRA_DEFENSE_BONUS;
    }

    @Override
    protected void gameTick() {
        if(remainingCooldown!=0){
            remainingCooldown=remainingCooldown-1;
        }
    }
}

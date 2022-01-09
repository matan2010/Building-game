package Player;

import Enemy.Enemy;
import Tile.Unit;

public class Rogue extends Player{
    private int cost;
    private int currentEnergy;
    protected static final int MAXIMAL_VALUE = 100;
    protected static final int EXTRA_ATTACK_BONUS = 3;

    protected Rogue(String name, int healthCapacity, int attack, int defense,int cost) {
        super(name, healthCapacity, attack, defense);
        this.cost=cost;
        this.currentEnergy=MAXIMAL_VALUE;
    }

    protected int gainExtraAttack(){
        return level * EXTRA_ATTACK_BONUS;
    }

    public void addExperience(int experienceGained){
        experience=experience+experienceGained;
        while (this.experience>=levelUpRequirement()){
            super.addExperience(experienceGained);
            currentEnergy = MAXIMAL_VALUE;
            this.setAttack(getAttack() + gainExtraAttack());
        }
    }

    @Override
    protected void gameTick() {
        currentEnergy=Math.min(currentEnergy+10,MAXIMAL_VALUE);
    }




}

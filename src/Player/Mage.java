package Player;

import Enemy.Enemy;
import Tile.Unit;

public class Mage extends Player{
    private int manaPool;
    private int manaCost;
    private int currentMana;
    private int spellPower;
    private int hitCount;
    private int range;

    protected static final int MANA_POOL_BONUS = 25;
    protected static final int CURRENT_MANA_BONUS = 4;
    protected static final int EXTRA_CURRENT_MANA_BONUS = 1;
    protected static final int SPELL_POWER_BONUS = 10;

    protected Mage(String name, int healthCapacity, int attack, int defense,int manaPool,int manaCost,int spellPower,int hitCount,int range) {
        super(name, healthCapacity, attack, defense);
        this.manaPool=manaPool;
        this.manaCost=manaCost;
        this.currentMana=manaPool/4;
        this.spellPower=spellPower;
        this.hitCount=hitCount;
        this.range=range;
    }


    public void blizzard(Enemy enemy) {

    }

    public void addExperience(int experienceGained){
        experience=experience+experienceGained;
        while (this.experience>=levelUpRequirement()){
            super.addExperience(experienceGained);
            this.setManaPool(this.getManaPool() + gainManaPool());
            this.setCurrentMana(Math.min(this.getCurrentMana() + gainCurrentMana(), manaPool));
            this.setSpellPower(this.getSpellPower() + gainSpellPower());
        }

    }

    protected int gainManaPool(){
        return level * MANA_POOL_BONUS;
    }
    protected int gainCurrentMana(){ return manaPool/CURRENT_MANA_BONUS; }
    protected int gainSpellPower(){ return level * SPELL_POWER_BONUS; }
    protected int gainExtraCurrentMana(){ return level * EXTRA_CURRENT_MANA_BONUS; }

    @Override
    protected void gameTick() {
        currentMana=Math.min(manaPool,currentMana+gainExtraCurrentMana());
    }


    public int getManaPool() {
        return manaPool;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setManaPool(int manaPool) {
        this.manaPool = manaPool;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }
}

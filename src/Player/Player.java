package Player;
import Enemy.Enemy;
import Tile.PlayerDeathCallback;
import Tile.Unit;

public abstract class Player extends Unit {
    public static final char playerTile = '@';
    protected static final int REQ_EXP = 50;
    protected static final int HEALTH_BONUS = 10;
    protected static final int ATTACK_BONUS = 4;
    protected static final int DEFENSE_BONUS = 1;


    protected PlayerDeathCallback deathCallback;

    protected int level;
    protected int experience;

    protected Player( String name, int healthCapacity, int attack, int defense) {
        super(playerTile, name, healthCapacity, attack, defense);
        this.level = 1;
        this.experience = 0;
    }

    protected int levelUpRequirement(){
        return REQ_EXP * level;
    }
    protected int gainHealth(){
        return level * HEALTH_BONUS;
    }
    protected int gainAttack(){
        return level * ATTACK_BONUS;
    }
    protected int gainDefense(){
        return level * DEFENSE_BONUS;
    }

    public void accept(Unit u){
        u.visit(this);
    }
    public void visit(Player player){};

    public void visit(Enemy enemy){
        super.battle(enemy);
        if(!enemy.alive()){
            swapPosition(enemy);
            onKill(enemy);
        }
    };


    protected abstract void gameTick();


    public int getLevel() {
        return level;
    }
    public int getExperience() {
        return experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String describe() {
        return String.format("%s\t\tLevel: %d\t\tExperience: %d/%d", super.describe(), getLevel(), getExperience(), levelUpRequirement());
    }

    public void onKill(Enemy enemy){
        int experienceGained=enemy.getExperienceValue();
        messageCallback.send(String.format("%s died. %s gained %d experience",enemy.getName(),getName(),experienceGained));
        addExperience(experienceGained);
        enemy.onDeath();
    }

    public void addExperience(int experienceGained){
        if(this.experience>=levelUpRequirement()) {
            experience = experience - levelUpRequirement();
            level = level + 1;
            this.getHealth().setHealthCapacity((this.getHealth().getHealthCapacity() + gainHealth()));
            this.getHealth().setAmount(this.getHealth().getHealthCapacity());
            this.setAttack(this.getAttack() + gainAttack());
            this.setDefense(this.getDefense() + gainDefense());
        }
    }
    protected void onDeath(){
        messageCallback.send("You lost.");
        deathCallback.call();
    }
    protected void abilityDamage(Enemy enemy,int abilityDamage){

    }
}


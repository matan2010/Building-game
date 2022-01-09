package Enemy;
import Player.Player;
import Tile.Unit;

public abstract class Enemy extends Unit {
    private int experienceValue;

    protected Enemy(char tile, String name, int healthCapacity, int attack, int defense,int experienceValue) {
        super(tile, name, healthCapacity, attack, defense);
        this.experienceValue=experienceValue;
    }

    public void visit(Player player){
        super.battle(player);
        if(!player.alive()){
            ////....game is over+
        }
    };
    public void visit(Enemy enemy){};

    protected abstract void gameTick(Player player);

    public int getExperienceValue() {
        return experienceValue;
    }
    public void onDeath(){}/////****//////
}

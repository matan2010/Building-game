package Enemy;

import Player.Player;
import Tile.Unit;

public class Trap extends Enemy{
    private int visibilityTime;
    private int invisibilityTime;
    private int ticksCount;
    private boolean visible;

    protected Trap(char tile, String name, int healthCapacity, int attack, int defense,int experienceValue,int visibilityTime,int invisibilityTime) {
        super(tile, name, healthCapacity, attack, defense,experienceValue);
        this.visibilityTime=visibilityTime;
        this.invisibilityTime=invisibilityTime;
        ticksCount=0;
        visible=true;
    }

    @Override
    public void accept(Unit unit) {

    }

    public void attack(Player player) {

    }

    @Override
    public void gameTick(Player player) {
        visible=ticksCount<visibilityTime;
        if(ticksCount==(visibilityTime+invisibilityTime)){
            ticksCount=0;
        }
        else {
            ticksCount=ticksCount+1;
        }
        if(this.position.range(player.getPosition())<2){
            attack(player);
        }

    }
}

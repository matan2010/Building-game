package Enemy;

import Player.Player;
import Tile.Unit;

public class Monster extends Enemy{
    private int visionRange;

    protected Monster(char tile, String name, int healthCapacity, int attack, int defense,int visionRange,int experienceValue) {
        super(tile, name, healthCapacity, attack, defense,experienceValue);
        this.visionRange=visionRange;
    }

    public void gameTick(Player player){
        if(this.position.range(player.getPosition()) < visionRange){
            int dx=this.position.getX() - player.getPosition().getX();
            int dy=this.position.getY() - player.getPosition().getY();
            if(Math.abs(dx)>Math.abs(dy)){
                if(dx>0){

                }
                else {

                }
            }
            else{
                if(dy>0){

                }
                else {

                }
            }

        }
        else{

        }

    }

    @Override
    public void accept(Unit unit) {

    }

}

package Tile;

import Enemy.Enemy;
import Player.Player;

public abstract class Unit extends Tile{
    protected MessageCallback messageCallback;

    protected String name;
    protected Resource health;
    protected int attack;
    protected int defense;


    protected Unit(char tile, String name, int healthCapacity, int attack, int defense) {
        super(tile);
        this.name = name;
        this.health = new Resource(healthCapacity, healthCapacity);
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public Resource getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health.setHealthCapacity(health);
    }
    public void visit(Empty empty){
        swapPosition(empty);
    }
    public void visit(Wall wall){};

    public abstract void visit(Player player);
    public abstract void visit(Enemy enemy);

    protected void swapPosition(Tile tile){
        Position p = tile.position;
        tile.setPosition(this.getPosition());
        this.setPosition(p);
    }
    public void interact(Tile tile){
        tile.accept(this);
    }
    public void battle(Unit unit){
        messageCallback.send(String.format("%s engaged in combat with %s.\n%s\n%s",getName(),unit.getName(),describe(),unit.describe()));
        int damegeDone=Math.max(attack()-unit.defense(),0);
        unit.health.reduceAmount(damegeDone);
        messageCallback.send(String.format("%s dealt %d damage to %s.",getName(),damegeDone,unit.getName()));
    }

    public String describe() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttack(), getDefense());
    }


    public boolean alive(){
        return health.getAmount()>0;
    }
    public int attack(){
        return (int)(Math.random()*(attack+1));
    }
    public int defense(){
        return (int)(Math.random()*(defense+1));
    }
    protected abstract void onDeath();
}

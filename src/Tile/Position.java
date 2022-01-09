package Tile;

public class Position {
    private int x;
    private int y;

    public Position(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Double range(Position OtherPos){
    return Math.pow((Math.pow(getX()-OtherPos.getX(),2)+Math.pow(getY()-OtherPos.getY(),2)),0.5);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args) {
        int a=5;
        int b=-7;
        int c=1;
        for(int i=0;i<30;i++)
            System.out.println((int)(Math.random()*(5+1)));
    }
}

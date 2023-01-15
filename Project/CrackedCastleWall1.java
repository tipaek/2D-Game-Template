public class CrackedCastleWall1 extends Tile{
    public CrackedCastleWall1(int id){
        super(Assets.crackedCastleWall1, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return true;
    }
    
}
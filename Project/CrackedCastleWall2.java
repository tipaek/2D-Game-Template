public class CrackedCastleWall2 extends Tile{
    public CrackedCastleWall2(int id){
        super(Assets.crackedCastleWall2, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return true;
    }
    
}
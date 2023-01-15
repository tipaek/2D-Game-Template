public class CastleFloor extends Tile{
    public CastleFloor(int id){
        super(Assets.castleFloor, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return false;
    }
    
}
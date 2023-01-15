public class CrackedCastleFloorLight extends Tile{
    public CrackedCastleFloorLight(int id){
        super(Assets.crackedCastleFloorLight, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return false;
    }
    
}
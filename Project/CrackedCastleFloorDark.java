public class CrackedCastleFloorDark extends Tile{
    public CrackedCastleFloorDark(int id){
        super(Assets.crackedCastleFloorDark, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return false;
    }
    
}
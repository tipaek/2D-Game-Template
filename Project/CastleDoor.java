public class CastleDoor extends Tile{
    public CastleDoor(int id){
        super(Assets.castleDoor, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return true;
    }
    
}
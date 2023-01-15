public class PurpleFloor extends Tile{
    public PurpleFloor(int id){
        super(Assets.purplefloor, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return false;
    }
    
}
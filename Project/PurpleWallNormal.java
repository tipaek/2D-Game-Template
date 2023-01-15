public class PurpleWallNormal extends Tile{
    public PurpleWallNormal(int id){
        super(Assets.purplewallnormal, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return true;
    }
    
}
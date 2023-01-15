public class MossyDirtTile extends Tile{
    public MossyDirtTile(int id){
        super(Assets.mossyDirt, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return false;
    }
    
}
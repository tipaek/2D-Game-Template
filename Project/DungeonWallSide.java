public class DungeonWallSide extends Tile{
    public DungeonWallSide(int id){
        super(Assets.dungeonwallside, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return true;
    }
    
}
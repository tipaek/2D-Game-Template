public class DungeonWallSouth extends Tile{
    public DungeonWallSouth(int id){
        super(Assets.dungeonwallsouth, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return true;
    }
    
}
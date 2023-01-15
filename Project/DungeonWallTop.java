public class DungeonWallTop extends Tile{
    public DungeonWallTop(int id){
        super(Assets.dungeonwalltop, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return true;
    }
    
}
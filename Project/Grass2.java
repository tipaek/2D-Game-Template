public class Grass2 extends Tile{
    public Grass2(int id){
        super(Assets.grass2, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return false;
    }
    
}
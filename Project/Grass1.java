public class Grass1 extends Tile{
    public Grass1(int id){
        super(Assets.grass1, id);
    }

    //overidden
    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return false;
    }
    
}
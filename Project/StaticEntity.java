public abstract class StaticEntity extends Entity{ //a nonmoving entity, like a tree or a rock
    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);//this is the counterpart to the creature class, so it's similar
    }
}
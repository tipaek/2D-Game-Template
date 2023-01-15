import java.awt.Graphics;
public class Torch extends StaticEntity{
    public Torch(Handler handler, float x, float y){
        super(handler, x, y, 8, 8);
    }

    public void tick(){

    }

    public void die(){

    }

    public void render(Graphics g){
        g.drawImage(Assets.castleTorchFront, (int)(x - handler.getGameCamera().getXOffset()), (int)(y - handler.getGameCamera().getYOffset()), width, height, null);
    }
}
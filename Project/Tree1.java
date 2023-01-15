import java.awt.Graphics;

public class Tree1 extends StaticEntity{
    public Tree1(Handler handler, float x, float y){
        super(handler, x, y, 200, 300);

        bounds.x = 0;
        bounds.y = 170;
        bounds.width = 200 - 20;//bounds of tree
        bounds.height = 80;
    }

    public void tick(){

    }

    public void die(){
        System.out.println("The tree has died.");
    }

    public void render(Graphics g){
        g.drawImage(Assets.tree1, (int)(x- handler.getGameCamera().getXOffset()), (int)(y - handler.getGameCamera().getYOffset()), 200, 300, null);
    }
}
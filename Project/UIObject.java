import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;

public abstract class UIObject {
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;

    

    protected boolean hovering = false;//the boolean for if the cursor is hovering over a button

    public UIObject(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int) x, (int) y, width, height);

    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void onClick();

    public void onMouseMove(MouseEvent e){//if the mouse is hovering over the button
        if(bounds.contains(e.getX(), e.getY()))
            hovering = true;
            else
            hovering = false;
    }

    public void onMouseRelease(MouseEvent e){//if the mouse just clicked on the button
        if(hovering)
            onClick();
    }


    //accessor and mutator methods
public float getX()
    {
        return this.x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }
    


}
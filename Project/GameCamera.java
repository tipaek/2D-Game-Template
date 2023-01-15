public class GameCamera {//this class controls the portion of the map that is shown(aka the camera)
    private Handler handler;//the gameCamera object will take in a game class object in order to be able to use its methods and stuff, now the handler
    private float xOffset, yOffset;//these variables mark the offset of the current camera position needed
    public GameCamera(Handler handler, float xOffset, float yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.handler = handler;
    }

    public void checkBlankSpace(){//checks to see if the camera is showing any blank space, space that's not part of the world
        if(xOffset < 0){//parallel to yOffset stuff
            xOffset = 0;
        } else if(xOffset > handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth())//parallel to yOffset stuff
            xOffset = handler.getWorld().getWidth() * Tile.TILEWIDTH - handler.getWidth();

        if(yOffset < 0){//if the camera has to move less than 0, which is out of the map on the top side, it sets the position back to 0, the exact coordinate of where the world ends
            yOffset = 0;
        } else if(yOffset > handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight())//if the camera has to move out of the map on the bottom side, keep the camera at the border
            yOffset = handler.getWorld().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        
    }

    public void centerOnEntity(Entity e){//this method will set the camera offsets according to an entity's position
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }

    public void move(float xAmount, float yAmount){
        xOffset += xAmount;
        yOffset += yAmount;
        checkBlankSpace();
    }

    public float getXOffset(){
        return xOffset;
    }

    public void setXOffset(float xOffset){
        this.xOffset = xOffset;
    }

    public float getYOffset(){
        return yOffset;
    }

    public void setYOffset(float yOffset){
        this.yOffset = yOffset;
    }
}
public abstract class Creature extends Entity {// a sub class or category of
    // entity that is abstract, because it will contain methods for more subclasses
    // that are more specific
    // abstract subclasses don't have to use the abstract mother class' methods,
    // because
    // it's the middle man class, so it won't need to actually use them
    
    protected float speed;// variable to keep track of speed
    protected float xMove, yMove; // variables for horizontal and vertical position changes needed

// initial creatures' health, speed, width, and height
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 45;
    public static final int DEFAULT_CREATURE_HEIGHT = 75;

    public Creature(Handler handler, float x, float y, int width, int height) {// same inputs as the mother class'
                                                                               // constructor to be able to use it
        super(handler, x, y, width, height); // this will use the constructor for the mother class
       
        speed = DEFAULT_SPEED; // creatures set to default speed
        xMove = 0;
        yMove = 0;
    }

    public void move() {// changes the coordinates to move a creature if there are no collisions
        if(!checkEntityCollisions(xMove, 0f)){
            moveX();}
        if(!checkEntityCollisions(0f, yMove)){
            moveY();}
    }

    public void moveX() {// moving right, these move methods check for the direction of the character and
                         // whether or not they interfere with a certain side of the hitbox, collision
                         // detection basically
        if (xMove > 0) {
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;// gives the x coordinate of the tile
                                                                                  // the character is running into
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
                    && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))// stops the
                                                                                                      // creature from
                                                                                                      // moving, if
                                                                                                      // there is a
                                                                                                      // collision with
                                                                                                      // the top right
                                                                                                      // of the hitbox
            {
                x += xMove;
            } else{
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }
        } else if (xMove < 0) {// moving left
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;// gives the x coordinate of the tile the character
                                                                   // is running into
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
                    && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))// stops the
                                                                                                      // creature from
                                                                                                      // moving, if
                                                                                                      // there is a
                                                                                                      // collision with
                                                                                                      // the top right
                {                                                                                      // of the hitbox
                x += xMove;
                } else{
                    x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;//gives the x coordinate of the tile to the left
                }
        }
    }

    public void moveY() {// moving up
        if (yMove < 0) {
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
                    && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else{
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }
        } else if (yMove > 0) {// moving down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
                    && !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else{
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }

    // accessor and mutator methods
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getXMove() {
        return xMove;
    }

    public void setXMove(float xMove) {
        this.xMove = xMove;
    }

    public float getYMove() {
        return yMove;
    }

    public void setYMove(float yMove) {
        this.yMove = yMove;
    }

}
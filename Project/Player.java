import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public class Player extends Creature{//a class that counts as a creature and will actually use the methods
    int DEFAULT_PLAYER_WIDTH = 19, DEFAULT_PLAYER_HEIGHT = 53;//i use these variables to keep track of the default, but it doesn't actually
    //do anything

    //Animations
    private Animation animLeft, animRight, animAttackLeft, animAttackRight;

    //Attack timer or speed
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
    private Boolean attackLeft = false, attackRight = false;
    public Player(Handler handler, float x, float y){
        super(handler, x, y, (int)(19*2), (int)(53*2));//could use the variables from the super method so that you don't have to change the player parameters

        bounds.x = 11;
        bounds.y = 18;
        bounds.width = 20;
        bounds.height = 80;

        animLeft = new Animation(167, Assets.player_left);//the animation takes in the array of frames as well as the amount of time in milliseconds in between each frame
        animRight = new Animation(167, Assets.player_right);
        animAttackLeft = new Animation(100, Assets.playerAttackLeft);
        animAttackRight = new Animation(100, Assets.playerAttackRight);
    }

    public void tick(){//where to update any variables for an object
        //Animations

        animLeft.tick();//this will use the tick methods for the respective animations
        animRight.tick();//this means that the animation will keep updating in the background
        animAttackLeft.tick();
        animAttackRight.tick();

        //Movement
        getInput();//pos change needed
        move();//changing the character pos
        handler.getGameCamera().centerOnEntity(this);//for every tick, the camera variable offsets will change according to the player's position

        //Attack
        checkAttacks();
    }

    private void checkAttacks(){//checks if the player's attack registers using rectangles

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;

        Rectangle cb = getCollisionBounds(0,0);    
        Rectangle ar = new Rectangle();
        int arSize = 20;//size of the attack rectangle
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().aUp){
            ar.x = cb.x + cb.width / 2 - arSize / 2;//draws rectangle above the player centered if this key is pressed
            ar.y = cb.y - arSize;
            attackRight = true;
        } else if(handler.getKeyManager().aDown){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
            attackLeft = true;
        } else if(handler.getKeyManager().aLeft){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            attackLeft = true;
        } else if(handler.getKeyManager().aRight){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
            attackRight = true;
        } else{
            return;//if not attacking, don't do the rest of the method
        }

        attackTimer = 0;//resets attack timer

        for(Entity e : handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))//don't attack ourselves
                continue;
            if(e.getCollisionBounds(0,0).intersects(ar)){
                e.hurt(10);
                return;//only hit the entity once
            }
        }

        attackLeft = false;
        attackRight = false;
    }

    public void die(){
        System.out.println("You lose :(");
    }

    private void getInput(){//a method that manages inputs
        xMove = 0;//reset the position change needed every time
        yMove = 0;

        if(handler.getKeyManager().up)
            yMove = -speed;//moves the creature up depending on their speed
        if(handler.getKeyManager().down)
            yMove = speed;//moves the creature down depending on their speed
        if(handler.getKeyManager().left)
            xMove = -speed;//moves the creature left depending on their speed
        if(handler.getKeyManager().right)
            xMove = speed;//moves the creature right depending on their speed

    }

    public void render(Graphics g){//constantly load pictures
        g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getXOffset()), (int)(y - handler.getGameCamera().getYOffset()) , width, height, null);//converting the float variables into integers in order to fit the method requirements
        //g.setColor(Color.red); //these two lines are to display the hitbox for the player
        //g.fillRect((int)(x + bounds.x - handler.getGameCamera().getXOffset()), (int)(y + bounds.y - handler.getGameCamera().getYOffset()), bounds.width, bounds.height);
    }//the player gets drawn on the screen according to the camera's positioning
    //width and height variables from mother classes, this new command has width and height variables to adjust the image size

    private BufferedImage getCurrentAnimationFrame(){
        if(handler.getKeyManager().aUp || handler.getKeyManager().aLeft){
            return animAttackLeft.getCurrentFrame();
        }
        else if(handler.getKeyManager().aDown || handler.getKeyManager().aRight){
            return animAttackRight.getCurrentFrame();
        }

        if(xMove < 0){//this code checks for the direction the player is travelling and giving the correct frame
            return animLeft.getCurrentFrame();
        } else if(xMove > 0){
            return animRight.getCurrentFrame();
        } else if(yMove > 0){

            return animLeft.getCurrentFrame();
        }else if(yMove < 0){
            return animRight.getCurrentFrame();
        } else{
            return Assets.player;
        }

    }

}


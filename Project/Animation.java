import java.awt.image.BufferedImage;
public class Animation {
    private int speed, index;//the index goes through the frames array and the speed will give the amount of time between each frame in millis
    private long lastTime, timer;
    private BufferedImage[] frames;

    public Animation(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
        
    }

    public void tick(){//to keep track of time and update index
        timer += System.currentTimeMillis() - lastTime;//this will get the time in milliseconds since the last time tick has run
        lastTime = System.currentTimeMillis();//sets the last time to the most recent time, updates it

        if(timer > speed){
            index++;//if it's time to update frames, we go up the array by incrementing the index
            timer = 0;
            if(index >= frames.length)//this will check to see if the index has reached the end of the animation and will reset it if it has
                index = 0;
        }
    }

    public BufferedImage getCurrentFrame(){//this will return the picture currently needed for the animation
        return frames[index];
    }
}
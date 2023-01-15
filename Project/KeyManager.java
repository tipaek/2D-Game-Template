import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{//key listener is a class in java that can listen
    //to computer keyboard inputs and requires three methods to run

    private boolean[] keys;//an array of true/false statements for whether a key is pressed
    //every key has a keyboard id 

    public boolean up, down, left, right;//booleans that other classes will use for directions, this class is for detecting them

    public boolean aUp, aDown, aLeft, aRight;

    public KeyManager(){

        keys = new boolean[256];

    }

    public void tick(){
        //done to keep track of the time
        up = keys[KeyEvent.VK_W];//detecting whether or not a certain key is being pressed
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];

        aUp = keys[KeyEvent.VK_UP];//detecting whether or not a certain key is being pressed
        aDown = keys[KeyEvent.VK_DOWN];
        aLeft = keys[KeyEvent.VK_LEFT];
        aRight = keys[KeyEvent.VK_RIGHT];
    }

    public void keyPressed(KeyEvent e) {//whenever a person presses a key
        keys[e.getKeyCode()] = true;//spot in array set to true when a key is being pressed
        //the key code is the key id

    }
   
    public void keyReleased(KeyEvent e) {//whenever a person lets go of a key
        keys[e.getKeyCode()] = false;//spot in array set to false when a key is not being pressed

    }

    public void keyTyped(KeyEvent e) {//whenever a key is pressed in order to type something

    }
}
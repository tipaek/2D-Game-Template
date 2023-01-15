import java.awt.Graphics;
//a state is a position in the game, like a main menu screen or the game screen, in order to organize things, every state will have 
//its own class to organize things, but every state shares in common the fact that they all have a render method and a tick method
public abstract class State {
    //abstract classes can have abstract methods, which basically means that they don't have to be implemented or coded: they can just 
    //be declared. When an abstract class is used in another class, the abstract methods listed have to be coded in the other class, or
    //it won't work. States is going to be an abstract class, because it will contain the methods that
    //every game state will have, so you don't have to code each method in each class a bunch of times.

    public abstract void tick();//tick method every state needs

    public abstract void render(Graphics g);//render method every state needs
    //it also needs to take in a graphics object to use to be able to draw
    //we plan to have the graphics object be able to be used cross classes
    

    //game state manager below(a method that will allow the game to change states)
    private static State currentState = null;//the current state, it has to be declared as a state, but can be initialized to anything we want

    public static void setState(State state){//method that changes the current state, public for every class to use
        currentState = state;
    }

    public static State getState(){//accessor for the current state
        return currentState;
    }

    //making it so every state has a game object(so it can actually run using the game loop)
    protected Handler handler;//protected means can only be accessed by subclasses and this one
    
    public State(Handler handler){
        this.handler = handler;
    }
}
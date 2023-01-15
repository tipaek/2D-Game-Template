import java.awt.Graphics;

public class GameState extends State {
    // the class of the game state
    //it extends state to use the methods listed, since every state needs the methods in there
    //it won't compile until every abstract method is used

    
    private World world;
    TMXParser parser = new TMXParser();

   public GameState(Handler handler)  { //constructor for game state
    super(handler);    
    
    world = new World(handler, "res(stands for resources and holds stuff for the program)\\worlds\\dungeon2.txt");
    handler.setWorld(world);//uses the handler accessor method to set the world
    
    
    

   } 
   
    public void tick() {
        world.tick();
       
        
    }

    
    public void render(Graphics g) {
        world.render(g);
        
        
    } 

    
}
import java.util.ArrayList;
import java.util.Comparator;
import java.awt.Graphics;
public class EntityManager {//this class will manage all the entities in the game
    private Handler handler;//entities will be declared here
    private Player player;
    private ArrayList<Entity> entities;//this arraylist will hold all of the entities, the 
    //amount of things in this array isn't set in stone, which is why we are using an arraylist instead
    private Comparator<Entity> renderSorter = new Comparator<Entity>(){
        @Override 
        public int compare(Entity a, Entity b){
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight())//gets the feet of the entity
            return -1;
            return 1;
        }
    };
    
    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    

    public void tick(){
        for(int i = 0; i < entities.size(); i++){
            Entity e = entities.get(i);//makes a variable that is equal to the entity in the position of i in the arrayList and renders it
            e.tick();
            if(!e.isActive())//if a creature dies, remove them
                entities.remove(e);
        }
        
        entities.sort(renderSorter);//sorts the entities according to the render sorter's compare method
    }

    public void render(Graphics g){
        for(Entity e : entities){//an enhanced for loop goes through every slot in the arraylist(same can be done with a normal for loop, but this is faster)
            e.render(g);
        }
       
    }

    public void addEntity(Entity e){//this method will add entities to the arraylist
        entities.add(e);
    }

    //accessor and mutator methods
    public Handler getHandler() {
        return this.handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    
    public Player getPlayer(){
        return this.player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public ArrayList<Entity> getEntities(){
        return this.entities;
    }

}
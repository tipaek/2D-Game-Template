import java.awt.Graphics;
public class World {//worlds will take in a game object
    
    private int width, height;//in terms of tiles of the world being a unit for each axis
    private int[][] tiles; //double dimension array to make the chart of the x and y, in form of numbers b/c tiles are taken in as id numbers
    private int spawnX, spawnY;
    private Handler handler;

//ENTITIES
    private EntityManager entityManager;

public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Player(handler, 100, 100));
        entityManager.addEntity(new Tree1(handler, 200, 800));
        
        
        loadWorld(path);//loading the world must come AFTER the entity manager is made
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);//puts the player in the spawn position
    }

public void tick(){
    entityManager.tick();
}

public void render(Graphics g){
    int xStart = (int)Math.max(0, handler.getGameCamera().getXOffset() / Tile.TILEWIDTH);//these variables will find what tiles of the world to load in to save resources
    int yStart = (int)Math.max(0, handler.getGameCamera().getYOffset() / Tile.TILEHEIGHT);
    int xEnd = (int)Math.min(width, (handler.getGameCamera().getXOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
    int yEnd = (int)Math.min(height, (handler.getGameCamera().getYOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
    
    for(int y = yStart; y < yEnd; y++){
        for(int x = xStart; x < xEnd; x++)
            getTile(x, y).render(g, (int)(x * Tile.TILEWIDTH - handler.getGameCamera().getXOffset()), (int)(y * Tile.TILEHEIGHT - handler.getGameCamera().getYOffset()));//casts the variables to make them work, then uses the offset variables in order to change the tiles' positions accordingly
    }
    entityManager.render(g);
}

public EntityManager getEntityManager(){
    return this.entityManager;
}

public Tile getTile(int x, int y){//gets the tile of a position
    if(x < 0 || y < 0 || x >= width || y >= height)
        return Tile.dirt;
   
    Tile t = Tile.tiles[tiles[x][y]]; //tile[x][y] returns the id of that position, so it gets put into the other class parameters to get the actual tile
    if( t == null)//to not break everything
        return Tile.dirt;
        return t;

}
private void loadWorld(String path){//method that takes a file and puts it into the multidimensional array
         String file = Utils.loadFileAsString(path);
         String[] tokens = file.split("\\s+");//puts the numbers in the world file into a string array that can be used to actually put things in

         width = Utils.parseInt(tokens[0]);//first number of the array is the width
         height = Utils.parseInt(tokens[1]);//second number of the array is the height

         spawnX = Utils.parseInt(tokens[2]);//third number of the array is the x pos of the spawn 
         spawnY = Utils.parseInt(tokens[3]);//fourth number of the array is the y pos of the spawn

         tiles = new int[width][height] ;//a multidimensional array for the world file that has spots for every tile
    for(int y = 0; y < height; y++){
        for(int x = 0; x < width; x++){
            tiles[x][y] = Utils.parseInt(tokens[(x + y *width) + 4]);//this will get the correct number from the single dimensional array into the multi-dimensional one. Add 4 in order to take the first four numbers of the world file into account
         }
        }
}   

public int getWidth(){//accessor for getting the width of the world
        return width;

    }

public int getHeight(){//accessor for getting the height of the world
        return height;
    }


}
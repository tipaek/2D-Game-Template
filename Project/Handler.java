
public class Handler {//this class contains access to variables, an easy waypoint
    private Game game;
    private World world;

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public int getWidth(){
        return game.getWidth();
    }

    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return this.game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public World getWorld() {
        return this.world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Handler(Game game){
        this.game = game;
    }

}
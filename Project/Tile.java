import java.awt.image.BufferedImage;
import java.awt.Graphics;
public class Tile {//this class will be the basis for all of the tiles
    //static stuff here
    public static Tile[] tiles = new Tile[256];
    public static Tile dirt = new DirtTile(0);//id for dirt is 0
    public static Tile mossyDirt = new MossyDirtTile(1);//id for mossydirt is 1
    public static Tile crackedCastleFloorDark = new CrackedCastleFloorDark(2);
    public static Tile crackedCastleFloorLight = new CrackedCastleFloorLight(3);
    public static Tile castleFloor = new CastleFloor(4);
    public static Tile crackedCastleWall1 = new CrackedCastleWall1(5);
    public static Tile crackedCastleWall2 = new CrackedCastleWall2(6);
    public static Tile castleDoor = new CastleDoor(7);
    public static Tile grass = new Grass1(8);
    public static Tile grass2 = new Grass2(9);
    public static Tile dungeonwallsouth = new DungeonWallSouth(10);
    public static Tile purplewallnormal = new PurpleWallNormal(11);
    public static Tile dungeonwallside = new DungeonWallSide(12);
    public static Tile dungeonwalltop = new DungeonWallTop(13);
    public static Tile purplefloor = new PurpleFloor(14);
    
    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;//how big a tile should be in pixels
    
    protected BufferedImage texture;
    protected final int id;//a way to identify the tile, like a name
    
    public Tile(BufferedImage texture, int id){//this object will need an image parameter of the tile
        this.texture = texture;
        this.id = id;

        tiles[id] = this;//puts the tile just created into the tile array
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){//normal render method, except with the coordinates for the tile
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public int getId(){
        return id;
    }

    public boolean isSolid(){//whether or not something is solid(unable to be walked upon)
        return false;
    }
}
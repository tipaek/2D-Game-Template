import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 517, height = 430, widthAndHeight2 = 32, castleWallSide = 8, castleFloorSide = 8, playerWidth = 19, playerHeight = 53, rogue = 8; //these variables show how large an image is in the sprite sheet to help be able to select and crop an image
    //this is so that if something is resized, then only the two variables have to be changed instead of literally everything
    //the numbers distinguish between different spritesheets for different image sizes
    public static BufferedImage player, mountainTop1, bushes1, dirt, mossyDirt, crackedCastleFloorDark, crackedCastleFloorLight, castleFloor, crackedCastleWall1, crackedCastleWall2, castleDoor, castleTorchFront, castleTorchLeft, castleTorchRight, castleFire;
    public static BufferedImage tree1, tree2, tree3, wood1, menu, menu1, free, chicken, grass1, grass2, dungeonwallsouth, purplewallnormal, dungeonwallside,dungeonwalltop, purplefloor; 
    public static BufferedImage[] player_right, player_left, menuPlayButton, animAttackLeft, playerAttackLeft, playerAttackRight;
    
    
    public static void main(String[] args){
        init();
    }


    public static void init(){//this method will load in everything once; this is so the game loop isn't constantly reopening the beginning scene
    //static means that the method can be called more easily, Foo.doStuff();, instead of Foo f = new Foo(); f.doStuff();
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\sprite sheet.jpg"));
        //spritesheet object declaration
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\tiles.jpg"));
        SpriteSheet playerSpriteRight = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\player char right.png"));
        SpriteSheet castleTileSprite = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\Castle Tile Set Sheet.png"));
        SpriteSheet playerSpriteLeft = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\player char left.png"));
        SpriteSheet trees = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\plant repack.png"));
        SpriteSheet menuButton1 = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\b_1.png"));
        SpriteSheet menuButton2 = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\b_5.png"));
        menuPlayButton = new BufferedImage[2];
        menuPlayButton[0] = menuButton1.crop(0, 0, 803, 372);
        menuPlayButton[1] = menuButton2.crop(0, 0, 602, 305);
        SpriteSheet menu = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\menu.png"));
        SpriteSheet free = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\free.png"));
        SpriteSheet roguelike = new SpriteSheet(ImageLoader.loadImage("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\roguelike.png"));
        
        player_left = new BufferedImage[6];
        player_right = new BufferedImage[6];
        player_right[0] = playerSpriteRight.crop(37, 15, playerWidth, playerHeight);
        player_right[1] = playerSpriteRight.crop(68, 15, playerWidth, playerHeight);
        player_right[2] = playerSpriteRight.crop(102, 15, playerWidth, playerHeight);
        player_right[3] = playerSpriteRight.crop(133, 15, playerWidth, playerHeight);
        player_right[4] = playerSpriteRight.crop(165, 15, playerWidth, playerHeight);
        player_right[5] = playerSpriteRight.crop(199, 15, playerWidth, playerHeight);

        player_left[0] = playerSpriteLeft.crop(259, 15, playerWidth, playerHeight);
        player_left[1] = playerSpriteLeft.crop(227, 15, playerWidth, playerHeight);
        player_left[2] = playerSpriteLeft.crop(198, 15, playerWidth, playerHeight);
        player_left[3] = playerSpriteLeft.crop(164, 15, playerWidth, playerHeight);
        player_left[4] = playerSpriteLeft.crop(135, 15, playerWidth, playerHeight);
        player_left[5] = playerSpriteLeft.crop(104, 15, playerWidth, playerHeight);

        playerAttackLeft = new BufferedImage[10];
        playerAttackRight = new BufferedImage[10];

        playerAttackLeft[0] = playerSpriteLeft.crop(296, 266, playerWidth, playerHeight);
        playerAttackLeft[1] = playerSpriteLeft.crop(259, 266, playerWidth, playerHeight);
        playerAttackLeft[2] = playerSpriteLeft.crop(222, 266, (int)(playerWidth*1.3), playerHeight);
        playerAttackLeft[3] = playerSpriteLeft.crop(190, 266, (int)(playerWidth*1.3), playerHeight);
        playerAttackLeft[4] = playerSpriteLeft.crop(165, 266, playerWidth, playerHeight);
        playerAttackLeft[5] = playerSpriteLeft.crop(126, 266, (int)(playerWidth*1.3), playerHeight);
        playerAttackLeft[6] = playerSpriteLeft.crop(97, 266, playerWidth, playerHeight);
        playerAttackLeft[7] = playerSpriteLeft.crop(70, 266, playerWidth, playerHeight);
        playerAttackLeft[8] = playerSpriteLeft.crop(29, 266, (int)(playerWidth*1.3), playerHeight);
        playerAttackLeft[9] = playerSpriteLeft.crop(0, 266, playerWidth, playerHeight);

        playerAttackRight[0] = playerSpriteRight.crop(0, 266, playerWidth, playerHeight);
        playerAttackRight[1] = playerSpriteRight.crop(29, 266, (int)(playerWidth*1.3), playerHeight);
        playerAttackRight[2] = playerSpriteRight.crop(70, 266, playerWidth, playerHeight);
        playerAttackRight[3] = playerSpriteRight.crop(97, 266, playerWidth, playerHeight);
        playerAttackRight[4] = playerSpriteRight.crop(126, 266, (int)(playerWidth*1.3), playerHeight);
        playerAttackRight[5] = playerSpriteRight.crop(165, 266, playerWidth, playerHeight);
        playerAttackRight[6] = playerSpriteRight.crop(190, 266, (int)(playerWidth*1.3), playerHeight);
        playerAttackRight[7] = playerSpriteRight.crop(222, 266, (int)(playerWidth*1.3), playerHeight);
        playerAttackRight[8] = playerSpriteRight.crop(259, 266, playerWidth, playerHeight);
        playerAttackRight[9] = playerSpriteRight.crop(296, 266, playerWidth, playerHeight);

        tree1 = trees.crop(0, 0, 67, 156);
        tree2 = trees.crop(193, 0, 98, 119);
        tree3 = trees.crop(128, 294, 98, 119);
        wood1 = trees.crop(135, 261, 16, 13);
        mountainTop1 = sheet.crop(7, 19, width, height);//this sets an image to the cropped sprite sheet
        bushes1 = sheet.crop(7, 2216, width, height);
        player = playerSpriteRight.crop(5, 15, playerWidth, playerHeight); 
        dirt = sheet2.crop(widthAndHeight2, widthAndHeight2, 32, 32);
        mossyDirt = sheet2.crop(0, widthAndHeight2*3, 32, 32);
        crackedCastleFloorDark = castleTileSprite.crop(castleFloorSide * 2, castleFloorSide * 11, castleFloorSide, castleFloorSide);
        crackedCastleFloorLight = castleTileSprite.crop(castleFloorSide * 3, castleFloorSide * 11, castleFloorSide, castleFloorSide);
        castleFloor = castleTileSprite.crop(castleFloorSide, castleFloorSide * 3, castleFloorSide, castleFloorSide);
        crackedCastleWall1 = castleTileSprite.crop(castleFloorSide, 0, castleWallSide, castleWallSide);
        crackedCastleWall2 = castleTileSprite.crop(0, castleFloorSide * 2, castleWallSide, castleWallSide);
        castleDoor = castleTileSprite.crop(castleFloorSide * 2, castleFloorSide * 8, castleFloorSide * 2, castleFloorSide * 3);
        castleTorchFront = castleTileSprite.crop(castleFloorSide * 13, 0, castleFloorSide, castleFloorSide);
        castleTorchLeft = castleTileSprite.crop(castleFloorSide * 13, castleFloorSide * 2, castleFloorSide, castleFloorSide);
        castleTorchRight = castleTileSprite.crop(castleFloorSide * 13, castleFloorSide, castleFloorSide, castleFloorSide);
        castleFire = castleTileSprite.crop(castleFloorSide * 13, castleFloorSide * 3, castleFloorSide * 3, castleFloorSide * 2);
        menu1 = menu.crop(0, 0,1280, 720); 
        grass1 = free.crop(13,15, 21, 22);
        grass2 = free.crop(52, 19, 23, 27);
        dungeonwallsouth = roguelike.crop(16, 0, 8, 8);
        purplewallnormal = roguelike.crop(32, 0, 8, 8);
        dungeonwallside = roguelike.crop(24, 0, 8, 8);
        dungeonwalltop = roguelike.crop(8, 0, 8, 8);
        purplefloor = roguelike.crop(56, 8, 8, 8);
        
        
        
        
        //if the sprite sheet allows, you can multiply the width and heights in order to get the coordinates
    }
}
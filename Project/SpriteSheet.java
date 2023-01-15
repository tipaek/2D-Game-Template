import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet; //uses 'this' in order to specify which of the sheets to use, since the same variable name was used; the name in the method is prioritized
        
    }

    public BufferedImage crop(int x, int y, int width, int height){//method for cropping the sprite sheet to get a specific image out of the chart of images
        return sheet.getSubimage(x, y, width, height); //this is a command that can return a specific part of an image
    }
}
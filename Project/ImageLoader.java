import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageLoader {//class to load images
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new File(path));//try statement to try a command
        } catch (IOException e) {
            e.printStackTrace();//catch statement to do things correctly when things don't load
            System.exit(1);//to end the game if the picture doesn't load
        }
        //this command returns the image of a given file path
        return null;
    }
    //images stored in buffered image objects
}
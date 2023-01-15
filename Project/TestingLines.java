import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TestingLines {
    public static void main(String[] args) {
        try {
            ImageIO.read(new File("res(stands for resources and holds stuff for the program)\\textures(holds the pictures)\\b_5.png"));
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        
    }
}
//C:\Java Stuff\First App\res(stands for resources and holds stuff for the program)\textures(holds the pictures)
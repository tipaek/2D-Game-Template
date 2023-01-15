import javax.swing.JFrame; //java default class imported to make the window
import java.awt.Canvas; //java default class imported to make pictures for the window
import java.awt.Dimension;//java default class imported to have dimensions for the picture
//jFrame is used in order to create new windows. 
//in this case, it's used to make the window of the game
public class Display {
    private JFrame frame; //window to hold the canvas(sheet of paper)
    private Canvas canvas; //the picture(the graphics and colors)(paint)

    private String title;
    private int width, height;//private variables, because other classes don't need them

    public Display(String title, int width, int height){//default constructor
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();//new method to not clutter things(makes things organized)

    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes sure the game closes when the window closes, almost always needed 
        frame.setResizable(false);//an optional command to allow/disallow users to resize the window
        frame.setLocationRelativeTo(null);//makes the window pop up at the center of the screen
        frame.setVisible(true);//windows are invisibile by default, so this command makes it visible
        
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height)); //making the picture that's the same size as the window, its starting size
        canvas.setMaximumSize(new Dimension(width, height)); //its max size
        canvas.setMinimumSize(new Dimension(width, height)); //its minimum size
        //by making all of the possible sizes the same, we basically just made the picture have a constant size
        canvas.setFocusable(false);//makes it so the application can focus itself

        frame.add(canvas); //adding  the canvas to the window
        frame.pack(); //optimizes the window to show the canvas
    }

    public Canvas getCanvas(){
        return canvas;//accessor method for the picture, because it's a private variable
    }

    public JFrame getFrame(){//accessor for getting a jframe for other classes to use
        return frame;
    }
}

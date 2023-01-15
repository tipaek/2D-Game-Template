import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
    //these java classes track the mouse, MouseEvents for each method listen track the specific action of the mouse implied by the method name
    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    private UIManager uiManager;



    public MouseManager(){

    }

    public void setUIManager(UIManager uiManager){
        this.uiManager = uiManager;
    }

    //Accessors

    public boolean isLeftPressed(){
        return leftPressed;
    }

    public boolean isRightPressed(){
        return rightPressed;
    }

    public int getMouseX(){
        return mouseX;
    }

    public int getMouseY(){
        return mouseY;
    }


    //Implemented methods
    @Override
    public void mouseDragged(MouseEvent e) {
        

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(uiManager != null)//passes events to the UIManager class
                uiManager.onMouseMove(e);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        

    }

    @Override
    public void mousePressed(MouseEvent e) {//checks to see if the left or right mouse buttons are pressed
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = true;
            else if(e.getButton() == MouseEvent.BUTTON3)
                rightPressed = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {//checks to see if the left or right mouse buttons are released
        if(e.getButton() == MouseEvent.BUTTON1)
        leftPressed = false;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;

            if(uiManager != null)
                uiManager.onMouseRelease(e);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        

    }

    @Override
    public void mouseExited(MouseEvent e) {
        

    }
    
}
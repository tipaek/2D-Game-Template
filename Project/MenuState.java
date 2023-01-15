import java.awt.Graphics;
import java.awt.Color;
public class MenuState extends State{
    private UIManager uiManager;
    
    
    public MenuState(Handler handler){
        super(handler);//uses the constructor from the game class in order to have a running game
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        
        uiManager.addObject(new UIImageButton(320, 200, 602, 305, Assets.menuPlayButton, new ClickListener(){

                    @Override
                    public void onClick() {//this is what clicking will do for this new button
                        handler.getMouseManager().setUIManager(null);//unsets the uimanager
                        State.setState(handler.getGame().gameState);//changes the game state for this button

                    }
                }));
    }

    public void tick(){
        uiManager.tick();
    }

    public void render(Graphics g){
        g.drawImage(Assets.menu1, 0, 0, 1280, 720, null);
        uiManager.render(g);
    }
}
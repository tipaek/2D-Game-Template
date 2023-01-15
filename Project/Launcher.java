 
public class Launcher{//class used to start the game 
    public static void main(String[] args) {
        Game game = new Game("First Game Pogu", 1280, 720);//types the name of the class in order to call the game constructor which calls the display constructor, makes a game object basically
        game.start();//method to run the game
    }
}
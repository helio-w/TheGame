package game;

public class Game{
    // There's only one instance of a game while the program is running
    private static final Game gameInstance = new Game();

    /* ------------- */
    /*  Constructor  */
    /* ------------- */

    public Game(){
        // We want to throw an exception here but at the moment we don't know how to do it properly
        if ((Game.gameInstance instanceof Game)){
            System.out.println("WARNING : Game is already initialized. Operation aborted.");
        }
    }

    /* ------------- */
    /*    Methods    */
    /* ------------- */

    public void start(){
        // Create a new Hero

        // Initialize Items

        // Initialize Maps and Exits

    }

    public void showOptions(){
        System.out.println("It seems you need to do something ...");
        
    }

    public static void main(String[] args){
    }
}
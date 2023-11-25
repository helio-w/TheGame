package characters;

import java.util.ArrayList;
import objects.Item;

public class Player extends Character{
    public ArrayList<Item> incentory = new ArrayList<Item>();
    public int attack = 1;
    private int speed = 1;


    private static Player instance;

    private Player(String name){
        super(name, 20);
    }

    /**
     * Creates a unique instance of Player
     * @param name : name of the player
     * @return return the instance
     */
    public static Player getPlayer(String name){
        if (instance == null) {
            instance = new Player(name);
        }
        return instance;
    }
}
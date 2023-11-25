package characters;

import java.util.ArrayList;
import objects.Item;

public class Player extends Character{
    public ArrayList<Item> inventory = new ArrayList<Item>();
    public int attack = 1;
    //private int speed = 1;


    private static Player instance;

    private Player(String name){
        super(name, 20, null); // TODO penser a mettre le joueur dans le première salle
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

    public void addItem(Item i){
        this.inventory.add(i);
    }
}
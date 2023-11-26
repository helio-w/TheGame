package characters;

import java.util.ArrayList;

import objects.Item;

import map.*;

public class Player extends Character{
    public ArrayList<Item> inventory = new ArrayList<Item>();
    public int attack = 1;
    //private int speed = 1;


    private static Player instance;

    private Player(String name, Location l){
        super(name, 20, l);
    }

    /**
     * Creates a unique instance of Player
     * @param name : name of the player
     * @return return the instance
     */
    public static Player getPlayer(String name, Location l){
        if (instance == null) {
            instance = new Player(name, l);
            l.getCharac().put(1, instance);
        }
        return instance;
    }

    /**
     * Add a item to the inventory of the player
     * @param i : item to add
     */
    public void addItem(Item i){
        this.inventory.add(i);
    }

    /**Display the name of the current location*/
    public void showLoc(){
        System.out.println("Current location : "+loc.NAME);
    }

    /**
     * Moves the player to the chosen exit destination if possible.
     * That is, if the exit is not locked or the player can unlock it with an item from his or her inventory.
     * @param k : Name of the exit the player wants to take
     */
    public void move(String k){
        Location loc = instance.loc;
        Exit e = loc.getExits().get(k);
        Location dest = e.DEST;
        if(e instanceof ExitKey){
            ExitKey ek = (ExitKey)e;
            ek.open();
            if(!(ek.getIsLock())){
                loc.getCharac().remove(1);
                instance.loc = dest;
                dest.getCharac().put(1, instance);
            }
        }else{
            loc.getCharac().remove(1);
            instance.loc = dest;
            dest.getCharac().put(1, instance);
        }
    }
}
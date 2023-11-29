package characters;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import objects.*;

import map.*;

public class Player extends Character{
    public Map<Integer, Item> inventory = new HashMap<Integer, Item>();
    public static final Integer HERO_ID = 1;
    //TODO peut-etre supprimer attack et speed
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
            l.getCharac().put(HERO_ID, instance);
        }
        return instance;
    }


    /**Display the name of the current location*/
    public void showLoc(){
        System.out.println("Current location : "+loc.NAME);
    }

    /**Allows the player to collect all the items in a location*/
    public void pickUpItems() {
        if (this.loc.getItems().isEmpty()) {
            System.out.println("There are no items on the ground!");
        } else {
            Iterator<Map.Entry<Integer, Item>> iterator = this.loc.getItems().entrySet().iterator();
            //the iterator will run through objects of type Map.Entry<Integer, Item>
            //entrySet() returns a set of key-value pairs from a map
            while (iterator.hasNext()) {
                Map.Entry<Integer, Item> entry = iterator.next();
                Item i = entry.getValue();
                this.inventory.put(i.ID, i);
                iterator.remove();
            }
        }
    }

    /**Allows the player to collect one items in a location */
    public void pickUpItem(String name){
        Iterator<Map.Entry<Integer, Item>> iterator = this.loc.getItems().entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Item> entry = iterator.next();
            String i_name = entry.getValue().NAME;
            if(name == i_name){
                Item i = entry.getValue();
                this.inventory.put(i.ID, i);
                iterator.remove();
                break;
            }
        }
    }

    /**Displays items in the player's inventory*/
    public void schowInventory(){
        if(this.inventory.isEmpty()){
            System.out.println("Your inventory is empty !");
        }else{
            System.out.print("Inventory : \n");
            for(Item i : inventory.values()){
                System.out.println(i);
            }
            System.out.println();
        }
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
                loc.getCharac().remove(HERO_ID);
                instance.loc = dest;
                dest.getCharac().put(HERO_ID, instance);
            }
        }else{
            loc.getCharac().remove(1);
            instance.loc = dest;
            dest.getCharac().put(HERO_ID, instance);
        }
    }

    public void use(String name){
        Iterator<Map.Entry<Integer, Item>> iterator = this.inventory.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Item> entry = iterator.next();
            String i_name = entry.getValue().NAME;
            if(name == i_name && entry.getValue() instanceof Food){
                iterator.remove();
                break;
            }
        }
    }
}
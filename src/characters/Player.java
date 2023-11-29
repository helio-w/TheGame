package characters;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

import objects.*;

import map.*;

public class Player extends Character{
    public Map<Integer, Item> inventory = new HashMap<Integer, Item>();
    public static final Integer HERO_ID = 1;

    private static Player instance;

    private Player(String name, Location l){
        super(name, 20, l, HERO_ID);
    }

    /**
     * Creates a unique instance of Player
     * @param name : name of the player
     * @param l : location of the player
     * @return return the instance
     */
    public static Player getPlayer(String name, Location l){
        try{
            if (instance == null) {
                instance = (Player)Character.createCharac(name, 20, l, HERO_ID);
                l.getCharac().put(HERO_ID, instance);
            }
        }catch(Exception e){
            System.err.println("Error getPlayer : there are already a character with 1 as id");
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
    public void showInventory(){
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

    /**
     * Allows the player to eat if the item used is an instance of Food
     * @param name : name of the item
     */
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

    /**
     * Kills a Character instantly because the player is super-strong, i.e. sets his health points at zero
     * @param name : name of the chracter
     */
    public void attack(String name){
        Iterator<Map.Entry<Integer, Character>> iterator = this.loc.getCharac().entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Character> entry = iterator.next();
            String i_name = entry.getValue().NAME;
            if(name == i_name){
                entry.getValue().hp = 0;
                break;
            }
        }
    }
}
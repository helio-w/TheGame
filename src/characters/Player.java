package characters;

import java.util.HashMap;
import java.util.Map;

import game.GameHandler;

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
                instance = new Player(name, l);
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
                System.out.println("You have picked up : "+i.NAME);
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
            if(name.equals(i_name)){
                Item i = entry.getValue();
                this.inventory.put(i.ID, i);
                System.out.println("You have picked up : "+i.NAME);
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
                System.out.println(e.txtCross); // Printing txt on console when exit is crossed 
                System.out.print(dest.TXTREACH);
                if(ek.getIsEnd()){ // if the exit allows you to finish the game
                    GameHandler.getInstance().terminate();; //finish the game
                }
            }
        }else{
            loc.getCharac().remove(1);
            instance.loc = dest;
            dest.getCharac().put(HERO_ID, instance);
            System.out.println(e.txtCross);
            System.out.print(dest.TXTREACH);
            if(e.getIsEnd()){
                    GameHandler.getInstance().terminate();
                }
        }
    }

    /**
     * Allows the player to eat if the item used is an instance of Food
     * @param name : name of the item
     */
    public void useItem(String name){
        Iterator<Map.Entry<Integer, Item>> iterator = this.inventory.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Item> entry = iterator.next();
            String i_name = entry.getValue().NAME;
            if(name.equals(i_name) && entry.getValue() instanceof Usable){
                ((Usable)entry.getValue()).use();
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

    /**
     * Allows the player to talk to an NPC
     * @param name : name of the NPC
     */
    public void talkToNPC(String name){
        Iterator<Map.Entry<Integer, Character>> iterator = this.loc.getCharac().entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Character> entry = iterator.next();
            String c_name = entry.getValue().NAME;
            if(name.equals(c_name)){
                Npc c = (Npc)entry.getValue();
                c.talk();
                break;
            }
        }
    }

    /**
     * Indicates whether the item exists in the player's inventory
     * @param name : name of the item
     * @return true if this is the case, false otherwise
     */
    public boolean hasItem(String name){
        Iterator<Map.Entry<Integer, Item>> iterator = this.inventory.entrySet().iterator();
        Boolean res = false;
        while(iterator.hasNext()){
            Map.Entry<Integer, Item> entry = iterator.next();
            String c_name = entry.getValue().NAME;
            if(name.equals(c_name)){
                res = true;
                break;
            }
        }
        return res;
    }
}
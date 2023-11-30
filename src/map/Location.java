package map;
import objects.Item;
import characters.Character;

import java.util.HashMap;
import java.util.Map;

public class Location{
    public final String NAME;
    public final String DESCRIPTION;
    public final String TXTREACH;

    private Map<Integer, Character> characs = new HashMap<Integer, Character>();
    private Map<String, Exit> exits = new HashMap<String, Exit>();
    private Map<Integer, Item> items = new HashMap<Integer, Item>();
    
    /**
     * Create a instance of Location
     * @param name : name of the location
     * @param desc : Description of the location
     * @param txt : Text for the player's arrival
     */
    public Location(String name, String txt, String desc){
        this.NAME = name;
        this.DESCRIPTION = desc;
        this.TXTREACH = txt;
    }

    /**Display the exits of a location*/
    public void showExits(){
        System.out.print(this.NAME+" : \n");
        for(Exit ex : exits.values()){
            System.out.println(ex);
        }
    }

    /**
     * Adds an exit to the HashMap exits of the Location
     * @param e : instance of the exit
     * @param name : name (key for the HashMap)
     */
    public void addExit(Exit e) throws Exception{
        if(this.exits.containsKey(e.NAME)){
            throw new Exception("Error addExit : exit name already present");
        }
        if(e.LOC != this){
            throw new Exception("Error addExit : incorrect location of"+e.NAME);
        }
        if(e.DEST != this){
            this.exits.put(e.NAME, e);
        }
    }
    /**
     * Create a instance of Exit and add it to the Map of her location
     * @param name : name of the exit
     * @param desc : description of the exit
     * @param dest : destination of the exit
     */
    public void createExit(String name, String desc, String txt,Location dest) throws Exception{
        Exit e = new Exit(name, desc, txt, this, dest);
        Exit e_bis = new Exit(name, desc, txt, dest, this);
        this.addExit(e);
        dest.addExit(e_bis);
    }
    /**
     * Create a instance of ExitKey and add it to the Map of her location
     * @param name : name of the exit
     * @param desc : description of the exit
     * @param dest : destination of the exit
     * @param l : the exit is lock or not ?
     * @param k : item to unlock the exit
     */
    public void createExitKey(String name, String desc, String txt,Location dest, boolean l, Integer id_k) throws Exception{
        Exit e = new ExitKey(name, desc, txt, this, dest, l, id_k);
        Exit e_bis = new ExitKey(name, desc, txt, dest, this, l, id_k);
        this.addExit(e);
        dest.addExit(e_bis);
    }

    public Map<String, Exit> getExits(){
        return exits;
    }

    public Map<Integer, Character> getCharac(){
        return characs;
    }

    /**Display the characters in a location*/
    public void showCharac(){
        System.out.print(this.NAME+" : \n");
        for(Character c : characs.values()){
            if(c.hp >0){
                System.out.println(c);
            }
        }
    }

    public Map<Integer, Item> getItems(){
        return items;
    }

    /**
     * Add a item in the location
     * @param i : item to add
     */
    public void addItemLoc(Item i){
        this.items.put(i.ID, i);
    }

    public void addCharacLoc(Character c){
        this.characs.put(c.ID, c);
    }

    public void showItems(){
        System.out.print(this.NAME+" : \n");
        for(Item i : items.values()){
            System.out.println(i);
        }
    }
}
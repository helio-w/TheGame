package map;
import objects.Item;

import java.util.HashMap;
import java.util.Map;

public class Location{
    public final String NAME;
    public final String DESCRIPTION;

    private Map<Integer, Character> characs = new HashMap<Integer, Character>();
    private Map<String, Exit> exits = new HashMap<String, Exit>();
    private Map<Integer, Item> items = new HashMap<Integer, Item>();
    
    /**
     * Create a instance of Location
     * @param name : name of the location
     * @param desc : Description of the location
     */
    public Location(String name, String desc){
        this.NAME = name;
        this.DESCRIPTION = desc;
    }

    /**Display the exits of a location*/
    public void showExits(){
        System.out.print(this.NAME+" : \n");
        for(Exit ex : exits.values()){
            System.out.println(ex);
        }
        System.out.println();
    }

    /**
     * Add an exit to the Map of a location
     * @param e
     * @param name
     */
    public void addExit(Exit e, String name){
        if(this.exits.containsKey(name)){
            System.out.println("Error addExit : exit name already present");
        }
        if(e.LOC != this){
            System.out.println("Error addExit : incorrect location of "+e.NAME);
        }
        if(e.DEST != this){
            this.exits.put(name, e);
        }
    }
    /**
     * Create a instance of Exit and add it to the Map of her location
     * @param name : name of the exit
     * @param desc : description of the exit
     * @param dest : destination of the exit
     */
    public void createExit(String name, String desc, Location dest){
        Exit e = new Exit(name, desc, this, dest);
        this.addExit(e, name);
    }
    /**
     * Create a instance of ExitKey and add it to the Map of her location
     * @param name : name of the exit
     * @param desc : description of the exit
     * @param dest : destination of the exit
     * @param l : the exit is lock or not ?
     * @param k : item to unlock the exit
     */
    public void createExitKey(String name, String desc, Location dest, boolean l, Item k){
        Exit e = new ExitKey(name, desc, this, dest, l, k);
        this.addExit(e, name);
    }

    public Map<String, Exit> getExits(){
        return exits;
    }

    public Map<Integer, Character> getCharac(){
        return characs;
    }

    public Map<Integer, Item> getItems(){
        return items;
    }

    /**
     * Delete a location and its exits
     * @param l : location to be deleted
     */
    public void deleteLoc(Location l){
        for(Exit e : l.exits.values()){
            l.exits.remove(e.NAME);
            e = null;
        }
        l = null;
    }

    public static void main(String[] args){
        Location l1 = new Location("L1", "Sorties dispo : L2 et L3");
        Location l2 = new Location("L2", "Sorties dispo : L1 et L4");
        Location l3 = new Location("L3", "Sorties dispo : L4");
        Location l4 = new Location("L4", "Sorties dispo : L3");

        l1.createExitKey("E1", "Sortie vers L2", l2, true, null);
        l1.createExit("E2", "Sortie vers L3", l3);

        l2.createExit("E1", "Sortie vers L1", l1);
        l2.createExit("E2", "Sortie vers L4", l4);

        l3.createExit("E1", "Sortie vers L4", l4);
        
        l4.createExit("E1", "Sortie vers L3", l3);

        l1.showExits();
    }
}
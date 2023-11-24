package map;
import objects.Item;

import java.util.HashMap;

public class Location{
    public final String NAME;
    public final String DESCRIPTION;

    private HashMap<Integer, Character> characs = new HashMap<Integer, Character>();
    private HashMap<Integer, Exit> exits = new HashMap<Integer, Exit>();
    private HashMap<Integer, Item> items = new HashMap<Integer, Item>();
    
    public Location(String name, String desc){
        this.NAME = name;
        this.DESCRIPTION = desc;
    }

    public void showExits(){
        System.out.print(this.NAME+" : \n");
        for(Exit ex : exits.values()){
            System.out.println(ex);
        }
        System.out.println();
    }

    public void addExit(Exit e, Integer id){
        if(this.exits.containsKey(id)){
            System.out.println("Error addExit : key already present");
        }
        if(e.DEST != this){
            this.exits.put(id, e);
        }
    }

    public HashMap<Integer, Exit> getExits(){
        return exits;
    }

    public HashMap<Integer, Character> getCharac(){
        return characs;
    }

    public static void main(String[] args){
        Location l1 = new Location("L1", "Sorties dispo : L2 et L3");
        Location l2 = new Location("L2", "Sorties dispo : L1 et L4");
        Location l3 = new Location("L3", "Sporties dispo : L4");
        Location l4 = new Location("L4", "Sorties dispo : L3");

        
    }

    
}
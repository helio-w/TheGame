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
        if(e.LOC != this){
            System.out.println("Error addExit : incorrect location of "+e.NAME);
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
        Location l3 = new Location("L3", "Sorties dispo : L4");
        Location l4 = new Location("L4", "Sorties dispo : L3");

        Exit e1 = new Exit("E1", "Sortie vers L2", l1, l2);
        Exit e2 = new Exit("E2", "Sortie vers L3", l1, l3);

        Exit e3 = new Exit("E3", "Sortie vers L1", l2, l1);
        Exit e4 = new Exit("E4", "Sortie vers L4", l2, l4);

        Exit e5 = new Exit("E5", "Sortie vers L4", l3, l4);

        Exit e6 = new Exit("E6", "Sortie vers L3", l4, l3);

        l1.addExit(e1, 1);
        l1.addExit(e2, 2);

        l2.addExit(e3, 1);
        l2.addExit(e4, 2);

        l3.addExit(e5, 1);

        l4.addExit(e6, 1);
    }

    
}
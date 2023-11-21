package game;

import java.util.ArrayList;
import java.util.List;

public class Location{
    public final String NAME;
    public final String DESCRIPTION;

    private List<Character> characs = new ArrayList<Character>();
    private List<Exit> exits = new ArrayList<Exit>();
    private List<Item> items = new ArrayList<Item>();
    
    public Location(String name, String desc){
        this.NAME = name;
        this.DESCRIPTION = desc;
    }

    public void showExits(){
        System.out.print(this.NAME+" : \n");
        for(Exit ex : exits){
            System.out.println(ex);
        }
        System.out.println();
    }

    public void addExit(Exit e){
        if(e.DEST != this){
            this.exits.add(e);
        }
    }

    public List<Exit> getExits(){
        return exits;
    }


    public static void main(String[] args){
        Location l1 = new Location("L1", "Sorties dispo : L2 et L3");
        Location l2 = new Location("L2", "Sorties dispo : L1 et L4");
        Location l3 = new Location("L3", "Sporties dispo : L4");
        Location l4 = new Location("L4", "Sorties dispo : L3");

        Exit el1 = new Exit("el1", "Sortie vers L1", l1);
        Exit el2 = new Exit("el2","Sortie vers L2", l2);
        Exit el3 = new Exit("el3", "Sortie vers L3", l3);
        Exit el4 = new Exit("el4", "Sortie vers l4", l4);

        l1.addExit(el2);
        l1.addExit(el3);

        l2.addExit(el1);
        l2.addExit(el4);

        l3.addExit(el4);

        l4.addExit(el3);

        l1.showExits();
        l2.showExits();
        l3.showExits();
        l4.showExits();
    }

    
}
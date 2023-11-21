package game;

import java.util.ArrayList;
import java.util.List;

public class Location{
    public final String NAME;
    public final String DESCRIPTION;

    private List<Character> charac = new ArrayList<Character>();
    private List<Exit> exits = new ArrayList<Exit>();
    private List<Item> items = new ArrayList<Item>();
    
    public Location(String name, String desc){
        this.NAME = name;
        this.DESCRIPTION = desc;
    }

    public void showExits(){
        for(Exit ex : exits){
            System.out.println(ex);
        }
    }

    public void addExit(Exit e){
        this.exits.add(e);
    }

    public List<Exit> getExits(){
        return exits;
    }


    public static void main(String[] args){
        Location l1 = new Location("L1", "Location 1");
        Location l2 = new Location("L2", "Location 2");

        Exit e = new Exit("e1", "Sortie vers L2", l2);

        l1.addExit(e);
        l1.showExits();
    }

    
}
package thegame;

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
            ex.
        }

    }

    
}
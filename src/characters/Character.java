package characters;
import java.util.HashMap;
import java.util.Map;

import map.Location;

public abstract class Character{
    public final String NAME;           // Name of the caracter
    public int hp;                // Health point of the caracter
    public Location loc;
    public final Integer ID;

    /**Hashmap of all characters */
     public static Map<Integer, Character> allCharac = new HashMap<Integer, Character>();

    /**
     * Create a instance a Character
     * @param name : name of the character
     * @param hp : amount of health point of the character
     * @param l : location of the character
     * @param id : id of the character
     */
    protected Character(String name, int hp, Location l, Integer id){
        this.NAME = name;
        this.hp = hp;
        this.loc = l;
        this.ID = id;
    }
    
    public String toString(){
        return "\tnom : "+this.NAME;
    }

}
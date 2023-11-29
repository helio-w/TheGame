package characters;
import java.util.HashMap;
import java.util.Map;

import map.Location;

public class Character{
    public final String NAME;           // Name of the caracter
    public int hp;                // Health point of the caracter
    public Location loc;
    public final Integer ID;

     public static Map<Integer, Character> allCharac = new HashMap<Integer, Character>();

    /**
     * Create a instance a Character
     * @param name : name of the character
     * @param hp : amount of health point of the character
     * @param l : location of the character
     */
    protected Character(String name, int hp, Location l, Integer id){
        this.NAME = name;
        this.hp = hp;
        this.loc = l;
        this.ID = id;
    }

    public static Character createCharac(String n, int hp, Location l, Integer id) throws Exception{
        Character i = new Character(n, hp, l, id);
        if(allCharac.containsKey(id)){
            throw new Exception("Error createCharac : item id already in allCharac");
        }else{
            allCharac.put(id, i);
            return i;
        }
    }

    public String toString(){
        return "\tnom : "+this.NAME;
    }

}
package characters;
import map.Location;

public abstract class Character{
    public final String NAME;           // Name of the caracter
    public int hp;                // Health point of the caracter
    public Location loc;

    /**
     * Create a instance a Character
     * @param name : name of the character
     * @param hp : amount of health point of the character
     * @param l : location of the character
     */
    public Character(String name, int hp, Location l){
        this.NAME = name;
        this.hp = hp;
        this.loc = l;
    }

    public String toString(){
        return "\tnom : "+this.NAME;
    }

}
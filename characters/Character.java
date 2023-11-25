package characters;
import map.Location;

public abstract class Character{
    public final String NAME;           // Name of the caracter
    public int hp;                // Health point of the caracter
    public Location loc;

    public Character(String name, int hp, Location l){
        this.NAME = name;
        this.hp = hp;
        this.loc = l;
    }

}
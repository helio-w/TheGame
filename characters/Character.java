package characters;

public abstract class Character{
    public final String NAME;           // Name of the caracter
    public int hp;                      // Health point of the caracter

    public Character(String name, int hp){
        this.NAME = name;
        this.hp = hp;
    }

}
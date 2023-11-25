package map;
import objects.Item;
import characters.Character;
import characters.Player;

public class ExitKey extends Exit{
    private boolean isLock;
    private final Item KEY;
    
    public ExitKey(String name, String desc, Location loc, Location dest, boolean lock, Item k){
        super(name, desc, loc, dest);
        this.isLock = lock;
        this.KEY = k;
    }
    
    @Override
    public String toString(){
        String lock = this.isLock?"YES":"NO"; //if isLoack then "YES" else "NO"
        return "Name : "+this.NAME+"\nDestination : "+this.DEST.NAME+"\nLock : "+lock+"\nDescription :\n"+this.DESCRIPTION;
    }

    /**
     * Unlock the exit if the player has the right item
     * @param id : id of the item
     */
    public void open(){
        Character hero = super.LOC.getCharac().get(1); // Hero is in first position
        if(((Player)hero).inventory.contains(KEY)){
            isLock = false;
        }else{
            System.out.println("La porte est vérouillée");
        }
    }
}
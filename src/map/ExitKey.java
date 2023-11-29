package map;
import characters.Character;
import characters.Player;

public class ExitKey extends Exit{
    private boolean isLock;
    private final Integer ID_KEY;
    
    /**
     * Create a instance of ExitKey
     * @param name : name of the exit
     * @param desc : description of the exit
     * @param loc : location of the exit
     * @param dest : destination of the exit
     * @param lock : status of the exit (locked or not)
     * @param k : item to unlock the exit
     */
    public ExitKey(String name, String desc, String txt,Location loc, Location dest, boolean lock, Integer id_k){
        super(name, desc, txt, loc, dest);
        this.isLock = lock;
        this.ID_KEY = id_k;
    }

    /**
     * Unlock the exit if the player has the right item
     * @param id : id of the item
     */
    public void open(){
        Character hero = super.LOC.getCharac().get(Player.HERO_ID); // Hero is in first position
        if(((Player)hero).inventory.containsKey(ID_KEY) || !(this.isLock)){
            isLock = false;
            System.out.println("The door is unlocked");
        }else{
            System.out.println("The door is locked");
        }
    }

    /**Used to obtain the status of the exit (locked or not)*/
    public boolean getIsLock(){
        return this.isLock;
    }
}
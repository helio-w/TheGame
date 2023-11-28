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
    //TODO supprimer le commentaire ci dessous à la fin
    /*
    @Override
    public String toString(){
        String lock = this.isLock?"YES":"NO"; //if isLoack then "YES" else "NO"
        return "\tName : "+this.NAME+"\n\tDestination : "+this.DEST.NAME+"\n\tLock : "+lock+"\n\tDescription :\n\t"+this.DESCRIPTION;
    }*/

    /**
     * Unlock the exit if the player has the right item
     * @param id : id of the item
     */
    public void open(){
        Character hero = super.LOC.getCharac().get(Player.HERO_ID); // Hero is in first position
        if(((Player)hero).inventory.containsKey(ID_KEY) || !(this.isLock)){
            isLock = false;
            System.out.println("La porte est ouverte");
        }else{
            System.out.println("La porte est vérouillée");
        }
    }

    /**Used to obtain the status of the exit (locked or not)*/
    public boolean getIsLock(){
        return this.isLock;
    }
}
package map;
import objects.Item;

public class ExitKey extends Exit{
    private boolean isLock;
    private final Item key;
    
    public ExitKey(String name, String desc, Location loc, Location dest, boolean lock, Item k){
        super(name, desc, loc,dest);
        this.isLock = lock;
        this.key = k;
    }
    
    @Override
    public String toString(){
        String lock = this.isLock?"YES":"NO"; //if isLoack then "YES" else "NO"
        return "Name : "+this.NAME+"\nDestination : "+this.DEST.NAME+"Lock : "+lock+"\nDescription :\n"+this.DESCRIPTION;
    }
/*
    public void open(){
        Character hero = super.LOC.getCharac().get(1);
        Item keyExit = hero.
        if(keyExit != null){
            isLock = false;
        }else{
            System.out.println("La porte est vérouillée");
        }
    }*/
}
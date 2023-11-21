package game;

public class Exit {
    public final String DESCRIPTION;
    private final Location DEST;

    public Exit(String name, String desc, Location dest){
        this.DESCRIPTION = desc;
        this.DEST = dest;
    }

    public String toString(){
        return "Destination : "+this.DEST.NAME+"\nDescription :\n"+this.DESCRIPTION;
    }
    
}
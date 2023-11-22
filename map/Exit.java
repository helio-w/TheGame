package map;

public class Exit {
    public final String DESCRIPTION;
    public final String NAME;
    public final Location DEST;

    public Exit(String name, String desc, Location dest){
        this.DESCRIPTION = desc;
        this.NAME = name;
        this.DEST = dest;
    }

    public String toString(){
        return "Nom : "+this.NAME+"\nDestination : "+this.DEST.NAME+"\nDescription :\n"+this.DESCRIPTION;
    }
    
}
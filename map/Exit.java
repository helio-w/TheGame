package map;

public class Exit {
    public final String DESCRIPTION;
    public final String NAME;
    public final Location DEST;
    public final Location LOC;

    public Exit(String name, String desc, Location loc, Location dest){
        this.DESCRIPTION = desc;
        this.NAME = name;
        this.DEST = dest;
        this.LOC = loc;
    }

    public String toString(){
        return "Nom : "+this.NAME+"\nDestination : "+this.DEST.NAME+"\nDescription :\n"+this.DESCRIPTION;
    }
}
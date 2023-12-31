package map;

public class Exit {
    public final String DESCRIPTION;
    public final String NAME;
    public final Location DEST;
    public final Location LOC;
    public String txtCross;
    private boolean isEnd = false;

    /**
     * Create a instance of Exit
     * @param name : name of the exit
     * @param desc : desciption of the exit
     * @param loc : location of the exit
     * @param dest : destination of the exit
     */
    public Exit(String name, String desc, String txt ,Location loc, Location dest){
        this.DESCRIPTION = desc;
        this.NAME = name;
        this.DEST = dest;
        this.LOC = loc;
        this.txtCross = txt;
    }

    public void end(){
        this.isEnd = true;
    }

    public boolean getIsEnd(){
        return this.isEnd;
    }

    public String toString(){
        return "\tName : "+this.NAME+"\n\tDestination : "+this.DEST.NAME+"\n\tDescription : "+this.DESCRIPTION +"\n";
    }

    public void setTXTCROSS(String txt){
        this.txtCross = txt;
    }
}
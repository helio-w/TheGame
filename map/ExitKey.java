package map;

public class ExitKey extends Exit{
    private boolean isLock;
    
    public ExitKey(String name, String desc, Location dest, boolean lock){
        super(name, desc, dest);
        this.isLock = lock;
    }
    
    public String toString(){
        String lock = this.isLock?"YES":"NO"; //if isLoack then "YES" else "NO"
        return "Name : "+this.NAME+"\nDestination : "+this.DEST.NAME+"Lock : "+lock+"\nDescription :\n"+this.DESCRIPTION;
    }
/* 
    public openExit(){

    }*/
}
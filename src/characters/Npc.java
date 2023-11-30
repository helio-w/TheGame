package characters;

import map.*;

public class Npc extends Character{

    private final String DIALOGUE; 

    private Npc(String name, Location l, int id, String dialogue){
        super(name, 20, l, id);
        DIALOGUE = dialogue;
    }

    public void talk(){
        System.err.print(DIALOGUE);
    }
}
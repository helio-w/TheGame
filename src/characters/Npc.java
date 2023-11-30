package characters;

import map.*;

public class Npc extends Character{

    private final String DIALOGUE; 

    private Npc(String name, Location l, int id, String dialogue){
        super(name, 20, l, id);
        DIALOGUE = dialogue;
    }

    /**
     * Create a npc, put him in allCharac, and return it
     * @param n : name of the npc
     * @param l : location of the npc
     * @param id : id of the npc
     * @param dialogue : dialogue of the npc
     * @return instance of npc
     * @throws Exception npc'id isn't unique;
     */
    public static Npc createNPC(String n, Location l, Integer id, String dialogue) throws Exception{
        Npc i = new Npc(n, l, id, dialogue);
        if(allCharac.containsKey(id)){
            throw new Exception("Error createCharac : item id already in allCharac");
        }else{
            allCharac.put(id, i);
            l.getCharac().put(id, i);
            return i;
        }
    }

    public void talk(){
        System.out.println(DIALOGUE);
    }
}
package objects;


import map.Exit;

public class Food extends Item implements Usable{

    private final String TXT_CHANGE;
    private final Exit TO_CHANGE;
    

    private Food(String name, String desc, Integer id, Exit toChange, String txt){
        super(name, desc, id);
        TO_CHANGE = toChange; 
        TXT_CHANGE = txt;
    }

    public static Food createFood(String name, String desc, Integer id, Exit toChange, String txt) throws Exception{
        Food i = new Food(name, desc, id, toChange, txt);
        if(allItems.containsKey(id)){
            throw new Exception("Error createFood : item id already in allItems");
        }else{
            allItems.put(id, i);
            return i;
        }
    }

    public void use(){
        System.out.println("Yummy !");
        TO_CHANGE.setTXTCROSS(TXT_CHANGE);
    }
}

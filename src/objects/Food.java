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

    /**
     * Create a food, add it to allItems and return it
     * @param n : name of the food
     * @param d : description of the food
     * @param id : id of the food (must be unique)
     * @return return a instance of Food
     * @throws Exception the id isn't unique
     */
    public static Food createFood(String name, String desc, Integer id, Exit toChange, String txt) throws Exception{
        Food i = new Food(name, desc, id, toChange, txt);
        if(allItems.containsKey(id)){
            throw new Exception("Error createFood : item id already in allItems");
        }else{
            allItems.put(id, i);
            return i;
        }
    }

    /**Applies the effect of food when consumed */
    public void use(){
        System.out.println("Yummy !");
        TO_CHANGE.setTXTCROSS(TXT_CHANGE);
    }
}

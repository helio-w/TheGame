package objects;

import java.util.Map;
import java.util.HashMap;

public class Item {
    public final String NAME;
    public final String DESC;
    public final Integer ID;

    private static Map<Integer, Item> allItems = new HashMap<Integer, Item>();

    private Item(String name, String desc, Integer id){
        this.NAME = name;
        this.DESC = desc;
        this.ID = id;
    }

    /**
     * Create an item, add it to allItems and return it
     * @param n : name of the item
     * @param d : description of the item
     * @param id : id of the item (must be unique)
     * @return return a instance of Item
     * @throws Exception the id isn't unique
     */
    public static Item createItem(String n, String d, Integer id) throws Exception{
        Item i = new Item(n, d, id);
        if(allItems.containsKey(id)){
            throw new Exception("Error createItem : item id already in allItems");
        }else{
            allItems.put(id, i);
            return i;
        }
    }
}
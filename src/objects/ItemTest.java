package objects;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTest {
    @Test
    public void testCreateItem(){
        try{    
            Item i = Item.createItem("null", "null", 1);
            Item i2 = Item.createItem("null", "null", 2);
            assertTrue(Item.allItems.containsValue(i) && Item.allItems.containsValue(i2));
        }catch(Exception e){}

    }
}

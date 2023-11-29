package map;

import objects.Item;
import characters.Character;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LocationTest {

    @Test
    public void testAddExit(){
        try{
            Location l = new Location("null", "null", "null");
            Location l2 = new Location("null", "null", "null");
            Exit e = new Exit("null", "null", "null", l, l2);

            l.addExit(e);
            assertTrue(l.getExits().containsKey(e.NAME));
        }catch(Exception e){
            System.err.println("\u001B[31mAn error has occurred : \u001B[0m\n\t"+e.getMessage());
        }
    }

    @Test
    public void testCreateExit(){
        try{
            Location l = new Location("null", "null", "null");
            Location l2 = new Location("null", "null", "null");
            l.createExit("null", "null", "null", l2);
            assertTrue(l.getExits().containsKey("null"));
            assertTrue(l2.getExits().containsKey("null"));
        }catch(Exception e){
            System.err.println("\u001B[31mAn error has occurred : \u001B[0m\n\t"+e.getMessage());
        }
    }

    @Test
    public void testCreateExitKey(){
        try{
            Location l = new Location("null", "null", "null");
            Location l2 = new Location("null", "null", "null");
            l.createExitKey("null", "null", "null", l2, true, 1);
            assertTrue(l.getExits().containsKey("null"));
            assertTrue(l2.getExits().containsKey("null"));
        }catch(Exception e){
            System.err.println("\u001B[31mAn error has occurred : \u001B[0m\n\t"+e.getMessage());
        }
    }

    @Test
    public void testAddItemLoc(){
        try{
            Location l = new Location("null", "null", "null");
            Item i = Item.createItem("null", "null", 1);
            l.addItemLoc(i);
            assertTrue(l.getItems().containsKey(i.ID));
        }catch(Exception e){
            System.err.println("\u001B[31mAn error has occurred : \u001B[0m\n\t"+e.getMessage());
        }
    }

    
}

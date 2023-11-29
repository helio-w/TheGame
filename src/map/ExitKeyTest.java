package map;

import objects.Item;
import characters.Player;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class ExitKeyTest {
    
    @Test
    public void testOpen(){
        try{
            Location l1 = new Location("l1", "null", "null");
            Location l2 = new Location("l2", "null", "null");
            Item i = Item.createItem("null", "null", 1);
            Player p = Player.getPlayer("hero", l1);
            p.inventory.put(i.ID, i);
            l1.createExitKey("null", "null", "null", l2, true, i.ID);
            ((ExitKey)l1.getExits().get("null")).open();
            assertFalse(((ExitKey)l1.getExits().get("null")).getIsLock());
        }catch(Exception e){}
    }
}

package characters;

import objects.Item;
import map.Location;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlayerTest {

    @Test
    public void testMoveExit(){
        try{
            Location l1 = new Location("L1", "Sortie(s) dispo : L2", "tadam");
            Location l2 = new Location("L2", "Sortie(s) dispo : aucune", "tadam");
            Player p = Player.getPlayer("Hero", l1);
        
            l1.createExit("E1", "Sortie vers L2", "evenement random",l2);
            p.move("E1");
            assertEquals(p.loc, l2);
        }catch(Exception e){
            System.err.println("\u001B[31mAn error has occurred : \u001B[0m\n\t"+e.getMessage()); // \u001B[31m change the text color to red and \u001B[0m to white
        }
    }

    @Test
    public void testMoveExitv2(){
        try{
            Location l1 = new Location("L1", "Sortie(s) dispo : L2", "tadam");
            Location l2 = new Location("L2", "Sortie(s) dispo : aucune", "tadam");
            Player p = Player.getPlayer("Hero", l1);
        
            l1.createExit("E1", "Sortie vers L2", "evenement random",l2);
            p.move("E1");
            assertEquals(p.loc, l2);
            p.move("E1");
            assertEquals(p.loc, l1);
        }catch(Exception e){
            System.err.println("\u001B[31mAn error has occurred : \u001B[0m\n\t"+e.getMessage()); // \u001B[31m change the text color to red and \u001B[0m to white
        }
    }

    @Test
    public void testPickUpItems(){
        try{
            Item i = Item.createItem("cle", "C'est une cle", 1);
            Item i2 = Item.createItem("null", "null", 2);
            Location l1 = new Location("L1", "Sortie(s) dispo : L2", "");
            Player p = Player.getPlayer("Hero", l1);
            l1.addItemLoc(i, i.ID);
            l1.addItemLoc(i2, i2.ID);
            assertFalse(p.inventory.containsKey(i.ID)||p.inventory.containsKey(i2.ID)); 
            p.pickUpItems();
            assertTrue(p.inventory.containsKey(i.ID)||p.inventory.containsKey(i2.ID));
        }catch(Exception e){
            System.err.println("\u001B[31mAn error has occurred : \u001B[0m\n\t"+e.getMessage()); // \u001B[31m change the text color to red and \u001B[0m to white
        }

    }

    
}
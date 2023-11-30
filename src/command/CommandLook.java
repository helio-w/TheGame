package command;

import game.GameHandler;
import map.*;
import characters.Player;

public class CommandLook extends Command{
	
	GameHandler theGame = GameHandler.getInstance();

	public CommandLook() {
		super("LOOK", "Give you a description of the environnement around you !\nYou can try to LOOK for EXITS, NPC, ITM or your INV.");
	}

	@Override
	public boolean execute(String[] args) {
		// TODO Auto-generated method stub
		Player ply = this.theGame.getPlayer();
		Location currentLoc = ply.loc;
		if (args.length >= 2) {
			int i = 1;
			// Print a list of thing in the location
			String arg2;
			while(i < args.length) {
				arg2 = args[i];
				// Parsing 2nd arg
				switch(arg2.toUpperCase()) {
					case "EXITS" : currentLoc.showExits();break;
					case "NPC" : currentLoc.showCharac();break;
					case "INV" : ply.showInventory();break;
					case "ITM" : currentLoc.showItems();break;
					default : Utils.printErr("Error LOOK : argument is not recognized");break;
				}	
				i++;
			}

		} else if (args.length == 1){
			System.out.println(currentLoc.DESCRIPTION);
		} else {
			Utils.printErr("Error LOOK : too much arguments");
			return false;
		}
		return true;
	}
	
	

}

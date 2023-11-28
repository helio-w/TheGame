package command;

import game.GameHandler;
import map.*;

public class CommandLook extends Command{
	
	GameHandler theGame = GameHandler.getInstance();

	public CommandLook() {
		super("LOOK", "Give you a description of the environnement around you");
	}

	@Override
	public boolean execute(String[] args) {
		// TODO Auto-generated method stub
		Location currentLoc = this.theGame.getCurrentMap();
		if (args.length > 1) {
			// Print a list of thing in the location
		} else {
			System.out.println(currentLoc.DESCRIPTION);
		}
		return false;
	}
	

}

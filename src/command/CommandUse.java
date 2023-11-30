package command;

import characters.Player;
import game.GameHandler;

public class CommandUse extends Command {
	GameHandler theGame = GameHandler.getInstance();
	public CommandUse() {
		super("USE", "Use the object in your inv in [argument]");
	}
	
	public boolean execute(String[] args) {
		Player ply = theGame.getPlayer();
		if(args.length == 2) {
			if(ply.hasItem(args[1].toUpperCase())) {						// Checking if Str in args[1] is a valid exit name (every exit is upper case)
				theGame.getPlayer().useItem(args[1].toUpperCase());
				return true;
			}else {
				Utils.printErr("Error USE : The item does not exist !");
				return false;
			}
		}else {
			Utils.printErr("Error USE : Too few or too much args.");
			return false;
		}
	}
}

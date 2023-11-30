package command;

import game.GameHandler;

public class CommandUse extends Command {
	public CommandUse() {
		super("USE", "Use the object in your inv in [argument]");
	}
	
	public boolean execute(String[] args) {
		GameHandler theGame = GameHandler.getInstance();
		if (args.length == 2) {
			
		}
		
		return false;
	}
}

package command;

import game.GameHandler;

public class CommandTake extends Command {
	GameHandler theGame = GameHandler.getInstance();
	
	public CommandTake() {
		super("TAKE", "Take the item in [argument] and put it in your bag !");
	}
	
	public boolean execute(String[] args) {
		if (args.length == 2) {
			
			return true;
		}else {
			Utils.printErr("Error TAKE : wrong nb of argument !");
			return false;
		}
		
	}
}

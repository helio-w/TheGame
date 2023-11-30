package command;

import game.GameHandler;
import characters.Player;

public class CommandTake extends Command {
	GameHandler theGame = GameHandler.getInstance();
	
	public CommandTake() {
		super("TAKE", "Take the item in [argument] and put it in your bag !");
	}
	
	public boolean execute(String[] args) {
		Player ply = this.theGame.getPlayer();
		if (args.length == 2) {
			ply.pickUpItem(args[1]);
			return true;
		}else if(args.length == 1) {
			ply.pickUpItems();			
			return true;
		}else {
			Utils.printErr("Error TAKE : wrong nb of argument !");
			return false;
		}
	}
}

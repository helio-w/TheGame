package command;

import java.util.Map;
import game.GameHandler;
import map.*;

public class CommandGo extends Command{
	GameHandler theGame = GameHandler.getInstance();
	
	public CommandGo() {
		super("GO", "Move the player to the destination in arg1 (arg1 must be a valid destination)");
	}
	
	public boolean execute(String[] args) {
		Location curLoc = theGame.getPlayer().loc;
		Map<String, Exit> exits = curLoc.getExits(); 							// Get the HashMap of Exits
		if(args.length == 2) {
			if(exits.containsKey(args[1].toUpperCase())) {						// Checking if Str in args[1] is a valid exit name (every exit is upper case)
				theGame.getPlayer().move(args[1].toUpperCase());
				System.out.println(exits.get(args[1].toUpperCase()).TXTCROSS); 	// Printing txt on console when exit is crossed
				return true;
			}else {
				Utils.printErr("Error GO : The Destination does not exist !");
				return false;
			}
		}else {
			Utils.printErr("Error GO : Too few or too much args.");
			return false;
		}
	}
}

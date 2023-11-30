/*package command;

import game.GameHandler;
import map.Location;

import java.util.Map;

import characters.*;
import characters.Character;

public class CommandTalk extends Command {
	GameHandler theGame = GameHandler.getInstance();
	
	public CommandTalk() {
		super("Talk", "Talk to the [argument] npc !");
	}
	
	public boolean execute(String[] args) {
		Location curLoc = theGame.currentLoc;
		Map<Integer, Character> characs = curLoc.getCharac(); 					// Get the HashMap of Exits
		if(args.length == 2) {
			if(characs.) {				// Checking if Str in args[1] is a valid exit name
				Character talkNpc = characs.get(args[1].toUpperCase());
				((Npc)talkNpc).talk();
				// TODO Implement lockedExit	
				return true;
			}else {
				Utils.printErr("Error TALK : The npc does not exist !");
				return false;
			}
		}else {
			Utils.printErr("Error TALK : Too few or too much args.");
			return false;
		}
	}
}*/
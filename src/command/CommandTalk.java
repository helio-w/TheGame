package command;

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
		Map<Integer, Character> characs = curLoc.getCharac(); 					// Get the HashMap of NPC
		if(args.length == 2) {
			if(characs.containsKey(args[1])) {				// Checking if Str in args[1] is a valid
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
}
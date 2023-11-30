package command;

import game.GameHandler;
import map.Location;

import characters.*;


public class CommandTalk extends Command {
	GameHandler theGame = GameHandler.getInstance();
	
	public CommandTalk() {
		super("Talk", "Talk to the [argument] npc !");
	}
	
	public boolean execute(String[] args) {
		Player ply = theGame.getPlayer();
		Location curLoc = ply.loc;		// Retieving current Location to check for NPC in map

		if(args.length == 2) {
			if(curLoc.hasNPC(args[1].toUpperCase())) {
				ply.talkToNPC(args[1].toUpperCase());
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
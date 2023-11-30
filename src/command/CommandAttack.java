package command;

import game.GameHandler;
import map.Location;

import characters.*;


public class CommandAttack extends Command {
	GameHandler theGame = GameHandler.getInstance();
	
	public CommandAttack() {
		super("Attack", "Attack [argument] the npc !");
	}
	
	public boolean execute(String[] args) {
		Player ply = theGame.getPlayer();
		Location curLoc = ply.loc;		// Retieving current Location to check for NPC in map

		if(args.length == 2) {
			if(curLoc.hasNPC(args[1].toUpperCase())) {
				ply.attack(args[1].toUpperCase());
				return true;
			}else {
				Utils.printErr("Error ATTACK : The npc does not exist !");
				return false;
			}
		}else {
			Utils.printErr("Error ATTACK : Too few or too much args.");
			return false;
		}
	}
}

package game;

import characters.*;
import map.*;
import java.util.ArrayList;
import command.*;

public class GameHandler {
	private boolean isFinished = false;	
	private static GameHandler instance;
	
	// private final ArrayList<Location> map = new ArrayList<Location>(); NOT NEEDED
	private final Player PLAYER;
	private Location currentLoc;
	
	// Empty constructor private to avoid external creation of any other instance
	private GameHandler() {

		
		/*
		 * 		Init of map
		 */
		Location startMap = new Location("startMap", "Just a rnd start map !");
		this.currentLoc = startMap; 	// Setting current Location to startMap
			
		/*
		 * 		Creating instance of player at the beginning of the game
		 * */
		
		this.PLAYER = Player.getPlayer("Heros", startMap); 
	}
	
	private GameHandler(Location startMap, String playerName) {
		this.PLAYER = Player.getPlayer(playerName, startMap);
	}
	
	
	// Getter of singleton
	public static GameHandler getInstance() {
		if (GameHandler.instance == null) {
			GameHandler.instance = new GameHandler();
		}
		return GameHandler.instance;
	}
	
	// Methods	
	public void startGame() {
		CommandHandler cmdHdl = CommandHandler.getInstance();
        System.out.print("\033[H\033[2J"); // Flush the console (seems it only works on Linux, not tested on Windows)
        System.out.flush();               
		System.out.println(Utils.printLine("Good afternoon sir ! It looks like you fall in a rabbit hole. Good luck to escape :) \n"
				+ "Maybe you should try to type LOOK to observe the surrounding area or cry for HELP if you're lost", 13));
		while(!this.isFinished) {
			cmdHdl.commandParser();
		}
		cmdHdl.closeScan();
	}
	
	public void terminate() {
		this.isFinished = true;
	}
	
	/*
	 *	   	Getters
	 */
	
	public boolean isFinished() {
		return this.isFinished;
	}
	
	public Player getPlayer() {
		return this.PLAYER;
	}
	
	public Location getCurrentMap() {
		return this.currentLoc;
	}
	
	/*
	 * 		Main for tinkering
	 */
	
	public static void main(String[] args) {
		GameHandler theGame = GameHandler.getInstance();
		theGame.startGame();
	}
}

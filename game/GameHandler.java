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
		this.currentLoc = startMap;
	}
	
	
	// Getter of singleton
	public static GameHandler getInstance() {
		if (GameHandler.instance == null) {
			GameHandler.instance = new GameHandler();
		}
		return GameHandler.instance;
	}
	
	/*
	 * 
	 */
	public static GameHandler createInstance(Location startMap, String playerName) {
		if (GameHandler.instance == null) {
			GameHandler.instance = new GameHandler(startMap, playerName);
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
		/* Locations init */
		Location firstClinicRoom = new Location("firstClinicRoom", 
				"You wake yourself in an empty room, the only light in the room is a candle on a table just beside your bed.\n"
				+ "The room is in a messy state the shelf contain books, but they seem too complicated for you.\n"
				+ "Clinics instruments are scattered in the room.\n"
				+ "On the table it seems there's a note.");
		
		Location secondClinicRoom = new Location("secondClinicRoom",
				"As you entered the room, the silence that was omnipresent start to fade as the sound of tearing flesh made itself heard.\n"
				+ "In the middle of the big room, a beast is eating.\n"
				+ "His black fur and facial features could make you think of a wolf, but there is also something human in him.\n"
				+ "The lycanthrope seam in a bad state, trace of burning on his body, but the fact the he satiate his hunger on a human isn't really appeasing.\n"
				+ "The only exit is behind the beast."	
				);
		/* End of locations init */
		/* Exits init */
		firstClinicRoom.createExit("toSecondClinicRoom", "secondClinicRoom", secondClinicRoom);
		/* End of exits init */
		/* NPC Init */
		
		/* End of NPC init */

		GameHandler theGame = GameHandler.createInstance(firstClinicRoom, "Chell");
		theGame.startGame();
	}
}

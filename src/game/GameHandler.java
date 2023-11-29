package game;

import characters.*;
import map.*;
import command.*;
import objects.*;

public class GameHandler {
	private boolean isFinished = false;		// State of the game
	private static GameHandler instance; 	// GameHandler is a singleton
	
	private final Player PLAYER;			// Player pointer to check HP and pass to commandHandler
	public Location currentLoc;			// CurrentLoc to pass to commandHandler
	
	// Constructor are private to avoid external creation of any other instance
	private GameHandler() {
		/*
		 * 		Init of map
		 */
		Location startMap = new Location("startMap", "Nothing to see here", "Just a rnd start map !");
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
		System.out.print(this.currentLoc.TXTREACH);
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
	
	public void changeMap(Location l) {
		this.currentLoc = l;
		System.out.print(this.currentLoc.TXTREACH);
	}
	
	public void takeExit(Exit e) {
		System.out.println(e.TXTCROSS);
		this.changeMap(e.DEST);
	}
	
	/*
	 * 		Main for tinkering
	 */
	
	public static void main(String[] args) throws Exception {
		/* Locations init */
		Location firstClinicRoom = new Location("firstClinicRoom", 
				"The room is in a messy state the shelf contain books, but they seem too complicated for you.\n"
				+ "Clinics instruments are scattered in the room.\n"
				+ "On the table it seems there's a note.",
				"You wake yourself in an empty room, the only light in the room is a candle on a table just beside your bed.\n");	
		Location secondClinicRoom = new Location("secondClinicRoom",
				"In the middle of the big room, a beast is eating.\n"
				+ "His black fur and facial features could make you think of a wolf, but there is also something human in him.\n"
				+ "The lycanthrope seam in a bad state, trace of burning on his body, but the fact the he satiate his hunger on a human isn't really appeasing.\n"
				+ "The only exit is behind the beast.",
				"As you entered the room, the silence that was omnipresent start to fade as the sound of tearing flesh made itself heard.\n"
				);
		/* End of locations init */
		/* Exits init */
		firstClinicRoom.createExit("DOOR", "toSecondClinicRoom",
				"The door opens on stair that leads downward, it's the only way to go forward so you take them", secondClinicRoom);
		/* End of exits init */
		/* Items init */
		Item itemList = Item.createItem("Key", "Just a test key", 0);
		
		firstClinicRoom.addItemLoc(itemList);
		/* End of items init*/
		/* NPC Init */
		
		/* End of NPC init */

		GameHandler theGame = GameHandler.createInstance(firstClinicRoom, "Chell");		// The cake is a lie
		theGame.startGame();
	}
}

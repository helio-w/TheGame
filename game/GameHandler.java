package game;

import characters.*;
import map.*;
import java.util.ArrayList;

public class GameHandler {
	private boolean isFinished = false;	
	private static GameHandler instance;
	
	private final ArrayList<Location> map = new ArrayList<Location>();
	private final Player PLAYER;
	private Location currentLoc;
	
	// Empty constructor private to avoid external creation of any other instance
	private GameHandler() {
		/*
		 * 		Creating instance of player at the beginning of the game
		 * */
		
		this.PLAYER = Player.getPlayer("Heros", null); 
		
		/*
		 * 		Init of maps
		 */
		Location startMap = new Location("Start map", "Juste a rnd start map");
		this.currentLoc = startMap; 	// Setting current Location to startMap
		
		// Adding Location to map list
		this.map.add(startMap);
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
		while(!this.isFinished) {
			
		}
		
	}
	
	public void terminate() {
		this.isFinished = true;
	}
	
	/*
	 * Getters
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
		
	}
}

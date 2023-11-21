package game;

public class GameHandler {
	private boolean isFinished = false;
	
	private static GameHandler instance;
	
	
	// Empty constructor
	private GameHandler() {
		
	}
	
	
	// Geter of singleton
	public static GameHandler getInstance() {
		if (GameHandler.instance == null) {
			GameHandler.instance = new GameHandler();
		}
		
		return GameHandler.instance;
	}
	
	// Methods
	
	public void terminate() {
		this.isFinished = true;
	}
	
	public boolean isFinished() {
		return this.isFinished;
	}
	
	
	public static void main(String[] args) {
		
	}
}

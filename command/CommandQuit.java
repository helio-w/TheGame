package command;
import game.GameHandler;

public class CommandQuit extends Command{

	public CommandQuit() {
		super("QUIT", "Quit the game (are you sure ?)");
	}

	@Override
	public boolean execute(String[] args) {
		// Get the game instance to delete it
		GameHandler theGame = GameHandler.getInstance();
		theGame.terminate();
		return true;
	}
	
	
}

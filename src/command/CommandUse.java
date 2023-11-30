package command;

public class CommandUse extends Command {
	public CommandUse() {
		super("USE", "Use the object in your inv in [argument]");
	}
	
	public boolean execute(String[] args) {
		return false;
	}
}

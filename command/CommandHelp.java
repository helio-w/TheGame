package command;

public class CommandHelp extends Command{
	
	public CommandHelp() {
		super("Help", "Show help about the command handler and the program");
	}
	
	public boolean execute(String[] args) {
		System.out.println("Hello ! I'm the help command !");
		return true;
	}

}

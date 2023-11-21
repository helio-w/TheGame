package command;

import java.util.Map.Entry;

public class CommandHelp extends Command{
	
	public CommandHelp() {
		super("Help", "Show help about the command handler and the program");
	}
	
	public boolean execute(String[] args) {
		System.out.println("Hello ! I'm the help command ! Here are the commands you can type : ");
		for (Entry<String, Command> entry : CommandHandler.COMMANDS.entrySet()) {
			String key = entry.getKey();
			Command value = entry.getValue();
			
		}
		return true;
	}

}

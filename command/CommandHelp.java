package command;

import java.util.Map.Entry;

public class CommandHelp extends Command{
	
	public CommandHelp() {
		super("Help", "Show help about the command handler and the program");
	}
	
	public boolean execute(String[] args) {
		String s = "";
		s += "\nGlad you asked some help ! Here is some informations on available commands\n";
		s += "General usage of commands is : COMMAND arg1 arg2 ...\n \n";
		s += "Available commands : \n";
		for (Entry<String, Command> entry : CommandHandler.COMMANDS.entrySet()) {
			String key = entry.getKey();
			Command value = entry.getValue();
			
			s += key + " : " +value.DESCRIPTION;
			s += "\n";
			
		}
		
		System.out.print(s);
		return true;
	}

}

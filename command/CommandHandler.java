package command;

import game.GameHandler;
import java.util.HashMap;
import java.util.Scanner;
public class CommandHandler {
	
	public static final HashMap<String, Command> COMMANDS = new HashMap<String, Command>();
	private static CommandHandler instance;
	
	private GameHandler theGame = GameHandler.getInstance();

	/*
	 * 		***** Constructors *****
	 * */
	
	// Constructor for the game
	// Commands should be added here 
	private CommandHandler() {
		Command cmdHelp = new CommandHelp();
		Command cmdQuit = new CommandQuit();
		
		
		// Adding these commands to the hashmap of command
		CommandHandler.COMMANDS.put("HELP", cmdHelp);
		CommandHandler.COMMANDS.put("QUIT", cmdQuit);
	}
	
	
	/*
	 * 		***** Methods *****
	 */
	
	public static CommandHandler getInstance() {
		if (CommandHandler.instance == null) {
			CommandHandler.instance = new CommandHandler();
		}
		
		return CommandHandler.instance;
	}
	
	public void commandParser() {
		Scanner scan = new Scanner(System.in);
		while(!theGame.isFinished()) {
			System.out.print("-> ");
			String command = scan.nextLine();
			this.execute(command);
		}
		scan.close();
		System.out.print("You either loose or quit the game ! Sayonara !");
	}
	
	
	public boolean execute(String command){
		String[] commandList;
		// Slipting args
		commandList = command.split(" "); 
		// Retrieving command instance corresponding to input
		if(CommandHandler.COMMANDS.containsKey(commandList[0].toUpperCase())) {
			Command myCmd = CommandHandler.COMMANDS.get(commandList[0].toUpperCase());
			myCmd.execute(commandList);
			return true;
		} else {
			Utils.printErr("Error while executing the command : command not found");
			return false;
		}
	}

	
	
	/*
	 * 		***** Main for further testing *****
	 * */
	
	public static void main(String[] args) {
		CommandHandler cmdHld = CommandHandler.getInstance();	
		cmdHld.commandParser();
	}
}

package command;

// import game.GameHandler;
import java.util.HashMap;
import java.util.Scanner;

public class CommandHandler {
	
	public static final HashMap<String, Command> COMMANDS = new HashMap<String, Command>();
	private static CommandHandler instance;
	
	// private GameHandler theGame = GameHandler.getInstance();
	private Scanner scan = new Scanner(System.in);

	/*
	 * 		***** Constructors *****
	 * */
	
	// Constructor for the game
	// Commands should be added here 
	private CommandHandler() {
		Command cmdHelp = new CommandHelp();
		Command cmdQuit = new CommandQuit();
		Command cmdLook = new CommandLook();
		Command cmdGo = new CommandGo();
		Command cmdTake = new CommandTake();
		Command cmdTalk = new CommandTalk();
		
		
		// Adding these commands to the hashmap of command
		CommandHandler.COMMANDS.put("HELP", cmdHelp);
		CommandHandler.COMMANDS.put("QUIT", cmdQuit);
		CommandHandler.COMMANDS.put("LOOK", cmdLook);
		CommandHandler.COMMANDS.put("GO", cmdGo);
		CommandHandler.COMMANDS.put("TAKE", cmdTake);
		CommandHandler.COMMANDS.put("TALK", cmdTalk);
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
		Utils.printDash(66);
		System.out.print("~> ");
		String command = this.scan.nextLine();
		Utils.printDash(66);

		this.execute(command);
	}
	
	public void closeScan() {
		this.scan.close();
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

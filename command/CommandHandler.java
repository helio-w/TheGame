package command;

import java.util.HashMap;
import java.util.Scanner;

public class CommandHandler {
	
	protected final HashMap<String, Command> COMMANDS;
	
	/*
	 * 		***** Constructors *****
	 * */
	
	// Constructor for custom command list
	public CommandHandler(HashMap<String, Command> hsmp) {
		this.COMMANDS = hsmp;
	}
	
	
	public CommandHandler() {
		this.COMMANDS = new HashMap<String, Command>();
	}
	
	/*
	 * 		***** Methods *****
	 */
	

	public void execute(String command) throws Exception{
		try {
			String[] commandList;
			// Slipting args
			commandList = command.split(" "); 
			// Retrieving command instance corresponding to input
			if(COMMANDS.containsKey(commandList[0])) {
				Command myCmd = COMMANDS.get(commandList[0]);
				myCmd.execute(commandList);
			} else {
				System.out.println("Error execute : command not found");
			}
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
	}

	
	
	/*
	 * 		***** Main for further testing *****
	 * */
	
	public static void main(String[] args) throws Exception {
		// System.out.println("Prout");
		
		// Definition of commands
		CommandHelp cmdHelp = new CommandHelp();
		
		HashMap<String, Command> myHsmp = new HashMap<String, Command>();
		
		myHsmp.put("help", cmdHelp);
		
		
		
		CommandHandler comHand = new CommandHandler(myHsmp);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("It seems I'm ready ! Please give me a command : ");
		String command = scan.nextLine();
		try {
			comHand.execute(command);
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		scan.close();
		
	}
}

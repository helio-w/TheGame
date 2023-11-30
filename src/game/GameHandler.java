package game;

import characters.*;
import map.*;
import command.*;
import objects.*;

public class GameHandler {
	private boolean isFinished = false;		// State of the game
	private static GameHandler instance; 	// GameHandler is a singleton
	
	private final Player PLAYER;			// Player pointer to check HP and pass to commandHandler
	public Location currentLoc;			// CurrentLoc to pass to commandHandler
	
	// Constructor are private to avoid external creation of any other instance
	private GameHandler() {
		/*
		 * 		Init of map
		 */
		Location startMap = new Location("startMap", "Nothing to see here", "Just a rnd start map !");
		this.currentLoc = startMap; 	// Setting current Location to startMap
			
		/*
		 * 		Creating instance of player at the beginning of the game
		 * */
		
		this.PLAYER = Player.getPlayer("Heros", startMap); 
	}
	
	private GameHandler(Location startMap, String playerName) {
		this.PLAYER = Player.getPlayer(playerName, startMap);
		this.currentLoc = startMap;
	}
	
	
	// Getter of singleton
	public static GameHandler getInstance() {
		if (GameHandler.instance == null) {
			GameHandler.instance = new GameHandler();
		}
		return GameHandler.instance;
	}
	
	/*
	 * 
	 */
	public static GameHandler createInstance(Location startMap, String playerName) {
		if (GameHandler.instance == null) {
			GameHandler.instance = new GameHandler(startMap, playerName);
		}
		return GameHandler.instance;
	}
	
	// Methods	
	public void startGame() {
		CommandHandler cmdHdl = CommandHandler.getInstance();
        System.out.print("\033[H\033[2J"); // Flush the console (seems it only works on Linux, not tested on Windows)
        System.out.flush();               
		System.out.println(Utils.printLine("Good afternoon sir ! It looks like you fall in a rabbit hole. Good luck to escape :) \n"
				+ "Maybe you should try to type LOOK to observe the surrounding area or cry for HELP if you're lost", 13));
		System.out.print(this.currentLoc.TXTREACH);
		while(!this.isFinished) {
			cmdHdl.commandParser();
		}
		cmdHdl.closeScan();
	}
	
	public void terminate() {
		this.isFinished = true;
	}
	
	/*
	 *	   	Getters
	 */
	
	public boolean isFinished() {
		return this.isFinished;
	}
	
	public Player getPlayer() {
		return this.PLAYER;
	}
	
	public void changeMap(Location l) {
		this.currentLoc = l;
		System.out.print(this.currentLoc.TXTREACH);
	}
	
	public void takeExit(Exit e) {
		System.out.println(e.TXTCROSS);
		this.changeMap(e.DEST);
	}
	
	/*
	 * 		Main for tinkering
	 */
	
	public static void main(String[] args) throws Exception {
		/* Locations init */
		Location firstClinicRoom = new Location("firstClinicRoom",
			"You wake yourself in an empty room, the only light in the room is a candle on a table just beside your bed.\n",
				"The room is in a messy state the shelf contain books, but they seem too complicated for you.\n"
				+ "Clinics instruments are scattered in the room.\n"
				+ "On the table it seems there's a note.");
		Location secondClinicRoom = new Location("secondClinicRoom",
				"As you entered the room, the silence that was omnipresent start to fade as the sound of tearing flesh made itself heard.\n",
				"In the middle of the big room, a beast is eating.\n"
				+ "His black fur and facial features could make you think of a wolf, but there is also something human in him.\n"
				+ "The lycanthrope seam in a bad state, trace of burning on his body, but the fact the he satiate his hunger on a human isn't really appeasing.\n"
				+ "The only exit is behind the beast."
				);
		Location ClinicYard = new Location("ClinicYard",
				"The orange dusk sky lit the surrounding.\n"
				+"You find yourself in the yard of the building.",
				"The place is surrounded by tall brick walls except for the metal gate, which is open.\n"
				+"The yard is covered in tombstones and a few dead trees.");
		Location CentralYarnham_1 = new Location("CentralYarnham_1",
		"You find yourself in a street built on a ledge, the city of Yarnham seem to be on verticality, and from where you are you have a good view of the city.",
		"On your left even higher than where you are you see a massive cathedral enclosed behind high walls built on a cliff and only connected to the rest of the city by a bridge that seem to be accesible by a place higher on your right.\n"
		+"As you look downward, you see on your right, in the distance a ladder that lead to a district lower.\n"
		+"The city of Yarnham may have been lively but right now the place reaks of blood."
		+"The gate to the clinic is still open, and the only other way is to continue on the street.");
		Location CentralYarnham_2 = new Location("CentralYarnham_2",
		"The paved street is at an angle.",
		"All the houses have their door closed and the candle in some street lamp are already burning.\n"
		+"You see what once was inhabitant of Yarnham, but now they were only husk roaming the street, their clothes showing trace of blood, elongated arms, and hair similar to fur sprouting from their head.\n"
		+"The street continue under the bridge or to the clinic."
		);
		Location CentralYarnham_3 = new Location("CentralYarnham_3",
		"You are at the end of the street, you see a gate on your right that would lead to an intersection.\n"
		+"It seemed to be the place you saw the ladder earlier.",
		"You hear a coughing from one of the windows, on wich you see a lit lantern."
		);
		Location LowerStreet_1 = new Location("LowerStreet_1",
		"You find yourself at an intersection.",
		"You can go forward in what you saw from higher as a vast open street.\n"
		+"On your left the narrow alley continue, your hear barking but in the except for a lantern lit on a door you can't see much.\n"
		+"On your right the street continue then turn in an angle on the left. It seem connected to the vast open street but much further than the forward direction.\n"
		);
		Location NarrowAlley = new Location("NarrowAlley",
		"You go in the narrow, the air is humid and sealed coffins are resting on some walls, you don't want to know why.\n"
		+"The barking from earlier entisify themself.",
		"You see a dog, his jaw is hanging wide open, and where is fur is missing you can see how skinny he is, but his sharp teeths tell you to not take this animal lightly.\n"
		+"You hear a grumbling voice from the door where the lantern is lit."
		);
		Location VastOpenStreet = new Location("VastOpenStreet",
		"A strange scene appear to take place in the vast street.",
		"A giant dead beast is crusified and a fire is burning at the feet of the creature.\n"
		+"The ones responsible for this, seem to still be roaming around it.\n"
		+"You see on your right a giant barricaded door, what's behind may be accesible from another place but not from here."
		);
		Location LowerFontaine = new Location("LowerFontaine",
		"You enter in a large open area with a fountain in the middle, but no water comes out.",
		"on your left a large structure seem to lead to the vast open street from earlier, but a giant barricaded door is in the way.\n"
		+"A difformed creature closer to the ogre than the human is knocking on the giant door.\n"
		+"The only way out of the area are a gate that lead to a graveyard, or the angle street."
		);
		Location Graveyard = new Location("Graveyard",
		"As you enter the graveyard, the first thing that come to your mind is that a fight had taken place here.",
		"A lot of the grave are destroyed, and blood is splatered all around the place.\n"
		+"In the middle of the graveyard the corpse of an old man is laying, dead."
		);
		Location CentralYarnham_4 = new Location("CentralYarnham_4",
		"You find yourself at an intersection.",
		"You can take the gate and go back to where you were.\n"
		+"On your left the way seem to lead to a ledged street like before.\n"
		+"On your right large stairs could take you higher, and maybe to the giant bridge of the cathedrale."
		);
		Location CentralYarnham_5 = new Location("CentralYarnham_5",
		"The street continue.\n"
		+"The view forward show the sign of a forest, maybe a way out of the cursed city.",
		"On one of the window on your right you see a lit lantern, and you hear a child voice coming from it."
		);

		/* End of locations init */
		/* Exits init */
		firstClinicRoom.createExit("DOOR", "toSecondClinicRoom",
				"The door opens on stair that leads downward, it's the only way to go forward so you take them", secondClinicRoom);
		/* End of exits init */
		/* Items init */
		Item itemList = Item.createItem("Key", "Just a test key", 0);
		
		firstClinicRoom.addItemLoc(itemList);
		/* End of items init*/
		/* NPC Init */
		
		/* End of NPC init */

		GameHandler theGame = GameHandler.createInstance(firstClinicRoom, "You");		// The cake is a lie
		theGame.startGame();
	}
}

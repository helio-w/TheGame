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
		System.out.println(
			"<Ha yes, the paleblood.>\n"
			+"The wheeled chair oldman approaches you\n"
			+"<Well you've come to the right place, Yarnham is the home of blood ministration>\n"
			+"As he comes right beside the bed your in, the only thing you can think is the bandage around both of his eyes.\n"
			+"<But first you will need a contract... Good. All signed and sealed>\n"
			+"He takes the needle, clean compare to the rest of the room.\n"
			+"<Now let's begin the transfusion>\n"
			+"You lounged yourself in the bed looking at the blood that will soon run in your veins.\n"
			+"<Oh, don't you worry. Whatever happens... You may think it all a mere bad dream...>\n"
			+"You fall into a deep sleep.\n");
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
				+ "On the table it seems there's a note."
		);
		Location secondClinicRoom = new Location("secondClinicRoom",
				"As you entered the room, the silence that was omnipresent start to fade as the sound of tearing flesh made itself heard.\n",
				"In the middle of the big room, a beast is eating.\n"
				+ "His black fur and facial features could make you think of a wolf, but there is also something human in him.\n"
				+ "The lycanthrope seam in a bad state, trace of burning on his body, but the fact the he satiate his hunger on a human isn't really appeasing.\n"
				+ "The only exit is behind the beast."
		);
		Location clinicYard = new Location("ClinicYard",
				"The orange dusk sky lit the surrounding.\n"
				+"You find yourself in the yard of the building.\n",
				"The place is surrounded by tall brick walls except for the metal gate, which is open.\n"
				+"The yard is covered in tombstones and a few dead trees."
		);
		Location centralYarnham_1 = new Location("CentralYarnham_1",
			"You find yourself in a street built on a ledge, the city of Yarnham seem to be on verticality, and from where you are you have a good view of the city.\n",
				"On your left even higher than where you are you see a massive cathedral enclosed behind high walls built on a cliff and only connected to the rest of the city by a bridge that seem to be accesible by a place higher on your right.\n"
				+"As you look downward, you see on your right, in the distance a ladder that lead to a district lower.\n"
				+"The city of Yarnham may have been lively but right now the place reaks of blood."
				+"The gate to the clinic is still open, and the only other way is to continue on the street."
		);
		Location centralYarnham_2 = new Location("CentralYarnham_2",
			"The paved street is at an angle.\n",
				"All the houses have their door closed and the candle in some street lamp are already burning.\n"
				+"You see what once was inhabitant of Yarnham, but now they were only husk roaming the street, their clothes showing trace of blood, elongated arms, and hair similar to fur sprouting from their head.\n"
				+"The street continue under the bridge or to the clinic."
		);
		Location centralYarnham_3 = new Location("CentralYarnham_3",
				"You are at the end of the street, you see a gate on your right that would lead to an intersection.\n"
				+"It seemed to be the place you saw the ladder earlier.\n",
			"You hear a coughing from one of the windows, on wich you see a lit lantern."
		);
		Location lowerStreet_1 = new Location("LowerStreet_1",
			"You find yourself at an intersection.\n",
				"You can go forward in what you saw from higher as a vast open street.\n"
				+"On your left the narrow alley continue, your hear barking but in the except for a lantern lit on a door you can't see much.\n"
				+"On your right the street continue then turn in an angle on the left. It seem connected to the vast open street but much further than the forward direction.\n"
		);
		Location narrowAlley = new Location("NarrowAlley",
				"You go in the narrow, the air is humid and sealed coffins are resting on some walls, you don't want to know why.\n"
				+"The barking from earlier entisify themself.\n",
				"You see a dog, his jaw is hanging wide open, and where is fur is missing you can see how skinny he is, but his sharp teeths tell you to not take this animal lightly.\n"
				+"You hear a grumbling voice from the door where the lantern is lit."
		);
		Location vastOpenStreet = new Location("VastOpenStreet",
			"A strange scene appear to take place in the vast street.\n",
				"A giant dead beast is crusified and a fire is burning at the feet of the creature.\n"
				+"The ones responsible for this, seem to still be roaming around it.\n"
				+"You see on your right a giant barricaded door, what's behind may be accesible from another place but not from here."
		);
		Location lowerFontaine = new Location("LowerFontaine",
			"You enter in a large open area with a fountain in the middle, but no water comes out.\n",
				"on your left a large structure seem to lead to the vast open street from earlier, but a giant barricaded door is in the way.\n"
				+"A difformed creature closer to the ogre than the human is knocking on the giant door.\n"
				+"The only way out of the area are a gate that lead to a graveyard, or the angle street."
		);
		Location graveyard = new Location("Graveyard",
			"As you enter the graveyard, the first thing that come to your mind is that a fight had taken place here.\n",
				"A lot of the grave are destroyed, and blood is splatered all around the place.\n"
				+"In the middle of the graveyard the corpse of an old man is laying, dead."
		);
		Location centralYarnham_4 = new Location("CentralYarnham_4",
			"You find yourself at an intersection.\n",
				"You can take the gate and go back to where you were.\n"
				+"On your left the way seem to lead to a ledged street like before.\n"
				+"On your right large stairs could take you higher, and maybe to the giant bridge of the cathedrale."
		);
		Location centralYarnham_5 = new Location("CentralYarnham_5",
				"The street continue.\n"
				+"The view forward show the sign of a forest, maybe a way out of the cursed city.",
			"On one of the window on your right you see a lit lantern, and you hear a child voice coming from it."
		);
		Location bridge = new Location("Bridge",
				"The first half of the bridge is strangely quiet.\n",
				"On the sides of the bridge you see strange statues representing human figures with a cloth hiding their face and looking at the floor grabing their hidden face in their hands.\n"
				+"The though about the meaning of it fade from your mind as you arrive at the door leading to the giant cathedrale."
		);
		Location cathedraleYard = new Location("CathedraleYard",
				"You stand in front of the cathedrale, the massif structure stand tall in front of you but strangely you hear the sound of a faint music box coming from the top of it.\n"
				+"A strange and ominous fealing emane from the edifice like the cathedral itself was enveloping by an invisible giant being moving very slowly and watching your every moves.\n"
				+"The though that this could not just be a fealing is enough to make you shiver.\n",
				"The yard have other pathway but all of them are obstruct by bariccade, your only choice is to enter the cathedrale"
		);
		Location insideCathedrale = new Location("InsideCathedrale",
				"As you enter the cathedral the air become stagnant it's like time stoped moving.\n"
				+"You walk in the long hallway of the building seeing stage statues, three man embalming a body, people covering their eyes.\n"
				+"In one giant room you even encounter an altar where a giant beast skull is resting.\n"
				+"The silence is growing more and more, as you have the constent fealing of being watched by someone, but their is only the moon gasing you through the windows.\n",
				"Do you really want to look for more disturbing things ?"
		);
		Location topOfCathedrale = new Location("TopOfCathedrale",
				"You finally arrive on the roof of the cathedrale, and as you walk the last stair, an unreal scene appear in front of you.\n"
				+"As the moon seem bigger than ever, you walk in a circular open arena surrounded by elegant pillars and walls erroded by time.\n"
				+"The area is paved by cold stone except for a field of white flower in the center, and in the middle of this field, a baby carriage.\n"
				+"You hear from it emanating the faint sound of a music box, but nothing else.\n",
				"You are already looking"
		);
		Location stopingTheBox = new Location("StopingTheBox",
				"You approched the baby carriage.\n"
				+"The music box at the center don't seem to end. You stand here hesitant to do anything.\n"
				+"And slowly you take the music box out of the pram, instantly stoping the melody.\n"
				+"After of few moment of silence your hear the cry of a baby... and then nothing.\n",
				"The moon is looking" // LA EN VRAI SA DEVRAI DECLANCHER DEUX DES 3 FIN ET DONC PAS DE LOOK
		);
		Location End = new Location("End","End.\n","This is the end");

		/* End of locations init */

		/* Items init */
		Item itemNote = Item.createItem("Note", "It is written : Seek paleblood to transcend the hunt", 0);
		firstClinicRoom.addItemLoc(itemNote);
		Item itemKey = Item.createItem("CathedralKey", "An elegant key, surely to open an important door", 1);
		graveyard.addItemLoc(itemKey);
		/* End of items init*/

		/* Exits init */
		firstClinicRoom.createExit("CLINIC_DOOR", "toSecondClinicRoom",
				"The door opens on stair that leads downward, it's the only way to go forward so you take them", secondClinicRoom);
		secondClinicRoom.createExit("YARD_DOOR", "toClinicYard",
				"The hallway leads to a door, you feel the cold hair behind it.", clinicYard);
		clinicYard.createExit("CLINIC_DOOR", "toCentralYarnham_1",
				"You take the gate.", centralYarnham_1);
		centralYarnham_1.createExit("CONTINUE_WALKING", "toCentralYarnham_2",
				"You continue forward on the street.", centralYarnham_2);
		centralYarnham_2.createExit("PASS_UNDER_BRIDGE", "toCentralYarnham_3",
				"You passes under the massive bridge that leads to the cathedrale.", centralYarnham_3);
		centralYarnham_3.createExit("LADER", "toLowerStreet",
				"You take the lader.", lowerStreet_1);
		centralYarnham_3.createExit("INTERSECTION_GATE", "toCentralYarnham_4",
				"You take the gate.", centralYarnham_4);
		lowerStreet_1.createExit("ALLEY", "toNarrowAlley",
				"You walk in the alley.", narrowAlley);
		lowerStreet_1.createExit("OPEN_STREET", "toVastOpenStreet",
				"You walk in the open street.", vastOpenStreet);
		lowerStreet_1.createExit("ANGLE_STREET", "toTheAngleStreet",
				"You take the street and turn at the angle.", lowerFontaine);
		lowerFontaine.createExit("GRAVEYARD_GATE", "toGraveyard",
				"you open the gate of the graveyard", graveyard);
		centralYarnham_4.createExit("WALK_IN_STREET", "toCentralYarnham5",
				"You continue forward on the street.", centralYarnham_5);
		centralYarnham_4.createExit("STAIRS", "toBridge",
				"You take the stairs.", bridge);
		bridge.createExitKey("CATHEDRALE_DOOR","toCathedraleYard",
				"You enter through the huge door.",cathedraleYard,true,1);
		cathedraleYard.createExit("INSIDE_CATHEDRALE", "toInsideCathedrale",
				"You go inside the cathedral", insideCathedrale);
		insideCathedrale.createExit("STAIRS_TO_TOP", "toTopCathedrale",
				"You take the stairs to the top", topOfCathedrale);
		topOfCathedrale.createExit("STOP_THE_BOX", "stopTheBox",
				"You take the stair to the top", stopingTheBox);
		End.createExit("LEAVE_IN_THE_FOREST", "Leave Yarnham through the forest",
				"You take the path into the wood, you don't know where it will lead you, but at least it will be out of Yarnham.\n"
				+"As the moon rise in the sky, you think to yourself that it will be a long night.\n"
				+"One that you will maybe not see the end.", centralYarnham_5);
		End.exitEnd("LEAVE_IN_THE_FOREST");
		/* End of exits init */
		
		/* NPC Init */
		
		/* End of NPC init */

		GameHandler theGame = GameHandler.createInstance(centralYarnham_5, "You");		// The cake is a lie
		theGame.startGame();
	}
}

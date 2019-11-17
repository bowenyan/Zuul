/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 * @modified by Bowen Yan
 * @date 5th, April 2008
 */

public class Game 
{
    private Parser parser;
    //private Room currentRoom;
    private Player player;
    //private Trade trade;    //test the Trade class
    //private Lock lock;      //test the Lock class
    //private CommandWords cmd;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        //createRooms();
        parser = new Parser();
        player = new Player();
        //trade = new Trade("","");
        //lock = new Lock("","");
        //cmd = new CommandWords();   
    }

    /**
     * Create all the rooms and link their exits together.
     */
    public void createRooms()
    {
        Room outside, theatre, pub, lab, office;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits and doors
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setDoor("east", theatre, true);
        outside.setDoor("west", pub, true);
        outside.setDoor("south", lab, true);
        outside.addItem(new Item("map","It is a map",1.0));
        outside.addItem(new Item("book","It is a book",2.1));

        theatre.setExit("west", outside);
        theatre.addItem(new Item("ticket","The ticket is for August Rush!",1.0));
        theatre.addItem(new Item("map","This is a map",1.0));

        pub.setExit("east", outside);
        pub.addItem(new Item("bottle","There are some milk in the bottle!",2.3));
        pub.addItem(new Item("map","There are a map!",2.3));

       // lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setDoor("north", outside, true);
        lab.addItem(new Item("map","There are a map!",2.3));
        lab.addItem(new Item("bottle","There are some water in the bottle!",2.3));

        office.setExit("west", lab);
        office.addItem(new Item("map","There are a map!",2.3));
        
        
        //initialise a NPC
        NPC npc = new NPC("teacher","He is a manager in lab");
        outside.addNpc(npc);
        Item npcItem = new Item("key","It is a key!",1.0);
        npc.setItem(npcItem);
        NPC npc1 = new NPC("teacher","He is a manager in lab");
        lab.addNpc(npc1);
        Item npcItem1 = new Item("key","It is a key!",1.0);
        npc1.setItem(npcItem1);

        //currentRoom = outside;   //start game outside
        player.setCurrentRoom(outside); //start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {        
    	createRooms();
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
        	boolean inCommandList = parser.testCommand(); 
        	if (inCommandList) {   //estimate whether the first word is vaild or not.
        		Command command = parser.getCommand();
        		finished = processCommand(command);
        	}
        	else {
        		System.out.println("Please use these commands below to be the first word:");
        		parser.showCommands();
        	}
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getLongDescription());
        System.out.println(player.getCurrentRoom().showItem());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public boolean processCommand(Command command)
    {
    	boolean wantToQuit = false;
        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        //wantToQuit = cmd.runCommand(command,player,parser);
        wantToQuit = command.executeCommand(command,player,parser);
    	return wantToQuit;
    }
    
    
  /*  
    public boolean processCommand(Command command) 
    {
    	//Room outside;
    	//outside = new Room("outside the main entrance of the university");
    	//player.setCurrentRoom(outside); 
    	//player.getCurrentRoom().addItem(new Item("map","It is a map",1.0));
        boolean wantToQuit = false;
        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("take")) {
        	System.out.println("Take item");
        	player.takeItem(command);
        }
        else if (commandWord.equals("drops")) {
        	player.dropItem(command);
        }
        else if (commandWord.equals("trade")) {
            trade.executeCommand(command, player);
        }
        else if (commandWord.equals("lock")) {
            lock.executeCommand(command, player);
        }
        return wantToQuit;
    }
  */

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    /*
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    */
    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    /*
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null)
            System.out.println("There is no door!");
        else {
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
    }
     */
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game. Return true, if this command
     * quits the game, false otherwise.
     */
    /*
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else
            return true;  // signal that we want to quit
    }
    */        
}

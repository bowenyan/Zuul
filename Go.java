/**
 * Class Go - a "go" action by the player.
 * It is a subclass of Command class.
 * Try to go to one direction. If there is an exit, enter the new 
 * room, otherwise print an error message.
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 6th, April 2008
 */
public class Go extends Command
{
	/**
     * Constructor for objects of class Go
     */
	public Go(String firstWord, String secondWord)
	{
		super(firstWord,secondWord);
	}
	
    /**
     * A player can choose where he/she want to go.
     * @param command
     * @param player
     * @return
     */
	public boolean executeCommand(Command command, Player player, Parser parser)
	{
		if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return false;
        }
		String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = player.getCurrentRoom().getExit(direction);
        Door doorRoom = player.getCurrentRoom().getDoor(direction); 

        if (nextRoom == null) {   //estimate whether the exit without a door is existent or not.
            System.out.println("There is no entrance without a door!");
        }
        else {
        	player.setCurrentRoom(nextRoom);  
            System.out.println(player.getCurrentRoom().getLongDescription());
            System.out.println(player.getCurrentRoom().showItem());
            return false;              //If there is an entrance between two rooms, the player can enter the next room directly.
        }
        if (doorRoom == null) {   //estimate whether the door is existent or not.
        	System.out.println("There is no door here!");
        }
        else if (doorRoom.getStatus()) {  //estimate the status of the door.
        	System.out.println("Please open the door first!");
        }
        else {
            player.setCurrentRoom(doorRoom.getRoom());
            System.out.println(player.getCurrentRoom().getLongDescription());
            System.out.println(player.getCurrentRoom().showItem());
            return false;     //the player can enter the next room through the door.
        }
        return false;
	}

}

/**
 * Class Unlock - Unlock the doors in the Room.
 * It is a subclass of Command class.
 * The Unlock command only works if the player is holding a key.
 * For simplicity it is enough if one key works for all doors.
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 6th, April 2008
 */
	
public class Unlock extends Command
{
	/**
	 * Constructor for objects of class Unlock
	 * @param firstWord
	 * @param secondWord
	 */
	public Unlock(String firstWord, String secondWord)
	{
		super(firstWord,secondWord);
	}
	
	/**
	 * If the player has a key, he can lock the door.
	 * @param command
	 * @param player
	 * @return true or false.
	 */
	public boolean executeCommand(Command command, Player player, Parser parser)
	{
		if (!command.hasSecondWord())
		{
			System.out.println("Unlock where?");
			return false;
		}
		Item key = player.checkItem("key");
		if (key == null)  //estimate whether the player has a key or not.
		{
			System.out.println("The player does not have a key!");
			return false;
		}
		String doorname = command.getSecondWord();
		Door nextroom = player.getCurrentRoom().getDoor(doorname);
		if (nextroom == null)   //estimate whether there is a door between two rooms.
		{
			System.out.println("There is no door between these two rooms!");
			return false;
		}
		if (nextroom.getStatus()==true)  //estimate the status of a door.
		{
			nextroom.unlock();
			System.out.println("The door has been opened!");
		}
		else
		{
			System.out.println("The door has already been opened!");
		}
		return false;
	}
}

/**
 * Class Lock - lock the doors in the Room. It is a subclass of Command class.
 * The lock command only works if the player is holding a key.
 * For simplicity it is enough if one key works for all doors.
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 6th, April 2008
 */
public class Lock extends Command
{
	/**
	 * Constructor for objects of class Lock
	 * @param firstWord
	 * @param secondWord
	 */
	public Lock(String firstWord, String secondWord)
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
			System.out.println("Lock where?");
			return false;
		}
		Item key = player.checkItem("key");
		if (key == null)         //estimate whether the player has a key or not.
		{
			System.out.println("The player doesnt have a key!");
			return false;
		}
		String doorname = command.getSecondWord();
		Door nextroom = player.getCurrentRoom().getDoor(doorname);
		if (nextroom == null)   //estimate whether there is a door between two rooms.
		{
			System.out.println("There is no door between these two rooms!");
			return false;
		}
		if (nextroom.getStatus()==false)  //estimate the status of a door.
		{
			nextroom.lock();
			System.out.println("The door has been locked!");
		}
		else
		{
			System.out.println("The door has already been locked!");
		}
		return false;
	}

}

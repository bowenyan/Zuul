

/**
 * Class Exit - exits in the Room.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 6th, April 2008
 */
public class Exit 
{
	/**
     * Fields for objects of class Exit
     */ 
	private Room room;
	
	/**
     * Create a exit in the room.
     */
	public Exit(Room room)
	{
		this.room = room;
	}
	
	/**
	 * Get the information of a room.
	 */
	public Room getRoom()
	{
		return this.room;
	}
	 
}

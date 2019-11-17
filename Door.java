/**
 * Class Door is subclass of Exit.
 * Doors which can be locked or unlocked.
 * @author Bowen Yan
 * @version 6th, April 2008
 *
 */
public class Door extends Exit 
{
	private boolean islocked;
	protected Room room;
	
	/**
     * Constructor for objects of class Door
     */	
	public Door(Room room, boolean islocked)
	{
		super(room);
		this.room = room;
		this.islocked = islocked;
	}
	
	/**
	 * A method to lock the door.
	 */
	public void lock()
	{
		this.islocked = true;
	}
	
	/**
	 * A method to unlock the door.
	 */
	public void unlock()
	{
		this.islocked = false;
	}
	
	/**
	 * Get the status of the door (locked or unlocked).
	 */
	public boolean getStatus()
	{
		return this.islocked;
	}
	
	/**
	 * Return the information of the current room.
	 */
	public Room getRoom()
	{
		return this.room;
	}
	
}

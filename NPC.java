/**
 * Class NPC - a Non-Player Character in the Room.
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 6th, April 2008
 */
public class NPC 
{
	/**
     * Fields for objects of class NPC
     */ 
	private String name;
	private String description;
	private Item item;

	/**
     * Constructor for objects of class NPC
     */
	public NPC(String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	/**
	 * Set an item to a Non-Player Character.
	 * @param item
	 */
	public void setItem(Item item)
	{
		if (this.item != null) //estimate whether a NPC has an item currently.
		{
			System.out.println("A non-player character can hold only one item at a time!");
			return;
		}
		this.item = item;
	}
	
	/**
	 * Trade an item with a player.
	 * @param item
	 */
	public void changeItem(Item item)
	{
		this.item = item;
	}
	
	/**
	 * Get the information of item belongs to a Non-Player Character.
	 * @return a Non-player Character's item.
	 */
	public Item getItem()
	{
		return this.item;
	}
	
	/**
	 * Get the name of a Non-Player Character.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get the description of a Non-Player Character.
	 */
	public String getDescrition()
	{
		return description;
	}

}


/**
 * Class Player - which contains all the information about the player.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 4th, April 2008
 */
import java.util.ArrayList;
import java.util.Iterator;

public class Player 
{
	/**
     * Fields for objects of class Player
     */ 
	private Room currentRoom;
	private ArrayList<Item> itemList;
	
	/**
     * Constructor for objects of class Player
     */
	public Player()
	{
		itemList = new ArrayList<Item>();
	}
	
	/**
	 * update the information of current room
	 */
	public void setCurrentRoom(Room currentRoom)
	{
		this.currentRoom = currentRoom;
	}
	
	/**
	 * get the information of current room
	 */
	public Room getCurrentRoom()
	{
		return currentRoom;
	}	
	
	/**
	 * Check whether the item is existent in the player's item list or not.
	 */
	public Item checkItem(String itemname)
    {
    	Item i;
    	Iterator<Item> it = itemList.iterator();
    	while (it.hasNext())
    	{
    		i = it.next();
    		if (i.getName().equals(itemname))
    		{
    			//System.out.println("This item is existent!");
    			return i;
    		}
    	}
    	return null;
    }
	
	 /**
     * Add an item to the player's item list, but cannot add items with the same name.
     * 
     */
    public void addItem(Item item)
    {
    	Item i;
    	Iterator<Item> it = itemList.iterator();
    	while (it.hasNext())
    	{
    		i = it.next();
    		if (i.getName().equals(item.getName()))//estimate whether the item is existent or not.
    		{
    			System.out.println("Cannot add item "+item.getName()+" with the same name!");
    		    return;
    		}
    	}
    	itemList.add(item);    	
    	System.out.println("The item "+item.getName()+" has been added in the player's item list!");
    	return;
    }
    
    /**
     * Remove an item from the player's item list.
     * 
     */
    public void removeItem(Item item)
    {
    	Item i;
    	Iterator<Item> it = itemList.iterator();
    	while (it.hasNext())
    	{
    		i = it.next();
    		if (i.getName().equals(item.getName()))//estimate whether the item is existent or not.
    		{
    			itemList.remove(item);
    			System.out.println("The item "+item.getName()+" has been removed from the player's item list!");
    			return;
    		}
    	}
    }
    
	/**
	 * Take item by player.
	 * @param command
	 * @return true or false
	 */
	/*
	public boolean takeItem(Command command)
	{
		//System.out.println(itemname);
		Item playeritem;
		if(!command.hasSecondWord())
		{
			System.out.println("Take what?");
			return false;
		}
		String itemname = command.getSecondWord();
		if (checkItem(itemname)!=null)
		{
			System.out.println("The item "+itemname+" in the player's item list!");
			return false;
		}
		if (currentRoom.checkItem(itemname)==null)
		{
			System.out.println("There is no item named "+itemname+" in the item list");
			return false;
		}
		else
		{
			playeritem = currentRoom.checkItem(itemname);
			itemList.add(playeritem);
			currentRoom.removeItem(playeritem);
			System.out.println("The item "+itemname+" has been taken!");
		}
		return true;
	}
	*/
	
	/**
	 * Drop item by player.
	 * @param command
	 * @return true or false.
	 */
	/*
	public boolean dropItem(Command command)
	{
		Item playeritem;
		if(!command.hasSecondWord())
		{
			System.out.println("Drop what?");
			return false;
		}
		String itemname = command.getSecondWord();
		if (checkItem(itemname)==null)
		{
			System.out.println("There is no item named "+itemname+" in the player's item list!");
			return false;
		}
		if (currentRoom.checkItem(itemname)!=null)
		{
			System.out.println("This item "+itemname+" is existent in the item list!");
			return false;
		}
		else
		{
			playeritem = checkItem(itemname);
			itemList.remove(playeritem);
			currentRoom.addItem(playeritem);
			System.out.println("The item "+itemname+" has been dropped!");
		}
		return true;
	}
	*/
}

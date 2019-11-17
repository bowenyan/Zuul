import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 * @modified by Bowen Yan
 * @date 3rd, April 2008
 */

public class Room 
{
    private String description;
    private HashMap<String, Exit> exits;        // stores exits of this room.
    private HashMap<String, Door> doors;        // stores doors of this room.
    private ArrayList<Item> List;
    private NPC npc;
    
    /**
     * Create a room described "description". Initially, it has no exits.
     * "description" is something like "in a kitchen" or "in an open court 
     * yard".
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Exit>();
        doors = new HashMap<String, Door>();
        List = new ArrayList<Item>();
    }

    /**
     * Define an exit from this room.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, new Exit(neighbor));
    }
    
    /**
     * Define a door from this room.
     */
    public void setDoor(String direction, Room neighbor, boolean islocked) 
    {
        doors.put(direction, new Door(neighbor,islocked));
    }
    
    /**
     * Return the description of the room (the one that was defined in the
     * constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of this room, in the form:
     *     You are in the kitchen.
     *     Exits: north west
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString()+ " "+ getDoorString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     */
    public String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys)
            returnString += " " + exit;
        return returnString;
    }
    
    /**
     * Return a string describing the room's doors, for example
     * "Doors: north west".
     */
    public String getDoorString()
    {
        String returnString = "Doors:";
        Set<String> keys = doors.keySet();
        for(String exit : keys)
            returnString += " " + exit;
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     */
    public Room getExit(String direction) 
    {
    	if (exits.get(direction)==null) {
    		return null;
    	}
        return exits.get(direction).getRoom();
    }
    
    /**
     * Return the door that is reached if we go from this room in direction
     * "direction". If there is no door in that direction, return null.
     */
    public Door getDoor(String direction) 
    {
        return doors.get(direction);
    }
    
    /**
     * Add an item to a room, but cannot add items with the same name.
     * 
     */
    public void addItem(Item item)
    {
    	Item i;
    	Iterator<Item> it = List.iterator();
    	while (it.hasNext())
    	{
    		i = it.next();
    		if (i.getName().equals(item.getName())) //estimate whether the item is existent or not.
    		{
    			System.out.println("Cannot add item "+item.getName()+" with the same name!");
    		    return;
    		}
    	}
    	List.add(item);    	
    	System.out.println("The item "+item.getName()+" has been added in the Room's item list!");
    	return;
    }
    
    /**
     * Remove an item from a room.
     * 
     */
    public void removeItem(Item item)
    {
    	Item i;
    	Iterator<Item> it = List.iterator();
    	while (it.hasNext())
    	{
    		i = it.next();
    		if (i.getName().equals(item.getName())) //estimate whether the item is existent or not.
    		{
    			List.remove(item);
    			System.out.println("The item "+item.getName()+" has been removed from the Room's item list!");
    			return;
    		}
    	}
    }
    
    /**
     * Check whether the item is existent in room's item list
     * by using the name of item
     * @param itemname
     * @return the name and description of item
     */
    public Item checkItem(String itemname)
    {
    	Item i;
    	Iterator<Item> it = List.iterator();
    	while (it.hasNext())
    	{
    		i = it.next();
    		if (i.getName().equals(itemname))
    		{
    			//System.out.println("This item a is existent in the item list!");
    			return i;
    		}
    	}
    	return null;
    }
    
    /**
     * Add a non-player character into a room.
     */
    public void addNpc(NPC npc)
    {
    	this.npc = npc;
    }
    
    /**
     * Get the information of a non-player character.
     */
    public NPC getNpc()
    {
    	return npc;
    }
    
    /**
     * Show all of items in the current room.
     */
    public String showItem()
    { 	
    	Item i;
    	String itemlist = "This room has these items:";
    	Iterator<Item> it = List.iterator();
    	while (it.hasNext())
    	{
    		i = it.next();
            itemlist = itemlist + " "+ i.getName();
    	}    	
    	return itemlist;
    }
}


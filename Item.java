
/**
 * Class Item - items in the Room.
 * It will deal with all of items's information.
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 3rd, April 2008
 */
public class Item 
{
	/**
     * Fields for objects of class Item
     */ 
	private String description;
	private String name;
	private double weight;
	
	/**
     * Constructor for objects of class Item
     */
	public Item(String name, String description, double weight)
	{
		this.name = name;
		this.description = description;
		this.weight = weight;
	}
	
	 /**
     * Get the description of a item.
     */
	public String getDescription()
	{
		return description;
	}
	
	 /**
     * Get the name of a item.
     */
	public String getName()
	{
		return name;
	}
	
	 /**
     * Get the weight of a item
     */
	public double getWeight()
	{
		return weight;
	}

}

/**
 * Class Drop - a "drop" action by the player. It is a subclass of Command class.
 * The player can drop any items in his or her item list.
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 6th, April 2008
 */
public class Drop extends Command
{
	/**
     * Constructor for objects of class Drop
     */
	public Drop(String firstWord, String secondWord)
	{
		super(firstWord,secondWord);
	}
	
    /**
     * A player can drop any items in his or her item list.
     * @param command
     * @param player
     * @return
     */
	public boolean executeCommand(Command command, Player player, Parser parser)
	{
		Item playeritem;
		if(!command.hasSecondWord())
		{
			System.out.println("Drop what?");
			return false;
		}
		String itemname = command.getSecondWord();
		if (player.checkItem(itemname)==null)     //estimate whether the item is existent in player's item list or not.
		{
			System.out.println("There is no item named "+itemname+" in the player's item list!");
			return false;
		}
		if (player.getCurrentRoom().checkItem(itemname)!=null)     //estimate whether the item is existent in room's item list or not.
		{
			System.out.println("This item "+itemname+" is existent in the room's item list!");
			return false;
		}
		else
		{   //change the current information of item list for the player and room.
			playeritem = player.checkItem(itemname);
			player.removeItem(playeritem);
			player.getCurrentRoom().addItem(playeritem);
			System.out.println("The item "+itemname+" has been dropped!");
		}
		return false;
	}

}

/**
 * Class Take - a "take" action by the player.
 * It is a subclass of Command class.
 * The player can take any items in the room.
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 6th, April 2008
 */
public class Take extends Command
{
	/**
     * Constructor for objects of class Take
     */
	public Take(String firstWord, String secondWord)
	{
		super(firstWord,secondWord);
	}
    /**
     * A player can take any items in the current room.
     * @param command
     * @param player
     * @return
     */
	public boolean executeCommand(Command command, Player player, Parser parser)
	{
		if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what to take...
            System.out.println("Take what?");
            return false;
        }
		Item playeritem;
		String itemname = command.getSecondWord();
		if (player.checkItem(itemname)!=null) //estimate whether item is existent in player's item list.
		{
			System.out.println("The item "+itemname+" in the player's item list!");
			return false;
		}
		if (player.getCurrentRoom().checkItem(itemname)==null)//estimate whether item is existent in room's item list.
		{
			System.out.println("There is no item named "+itemname+" in the item list!");
			return false;
		}
		else
		{   //change the current information of item list for the player and room.
			System.out.println("The item "+itemname+" has been taken by the player!");
			playeritem = player.getCurrentRoom().checkItem(itemname);
			player.addItem(playeritem);
			player.getCurrentRoom().removeItem(playeritem);
		}
		
		return false;
	}

}

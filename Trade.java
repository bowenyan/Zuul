/**
 * Class Trade - a "trade" action in the Room.
 * It is a subclass of Command class.
 * an NPC to trade its item for the item given to it by a player.
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 6th, April 2008
 */
public class Trade extends Command
{
	/**
     * Constructor for objects of class Trade
     */
	public Trade(String firstWord, String secondWord)
	{
		super(firstWord,secondWord);
	}
    /**
     * An NPC to trade its item for the item given to it by a player.
     * @param command
     * @param player
     * @return
     */
	public boolean executeCommand(Command command, Player player, Parser parser)
	{
		if (!command.hasSecondWord())
		{
			// if there is no second word, we don't know what should be traded...
			System.out.println("Trade what?");
			return false;
		}
		String itemname = command.getSecondWord();
		Item playeritem = player.checkItem(itemname);
		if (playeritem==null) //estimate whether the item is existent in player's item list or not.
		{
			System.out.println("There is no item named "+itemname+" in the player's item list!");
			return false;
		}
		if (player.getCurrentRoom().getNpc()==null)//estimate whether there is an NPC in current room or not.
		{
			System.out.println("There is no NPC in this room!");
			return false;
		}		
		Item npcitem = player.getCurrentRoom().getNpc().getItem();
		if (npcitem == null) //estimate whether the NPC has an item or not.
		{
			System.out.println("There is no item belonging to NPC!");
			return false;
		}
		//change the current information of item list for the player and NPC.
		player.addItem(npcitem);
		player.removeItem(playeritem);
		player.getCurrentRoom().getNpc().changeItem(playeritem);
		System.out.println("The trade has been done!");
		System.out.println("The NPC has gotten "+player.getCurrentRoom().getNpc().getItem().getName()+"!");
		System.out.println("The player has gotten a "+npcitem.getName()+"!");
		return false;
	}
}

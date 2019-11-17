/**
 * Class Quit - a "quit" action by the player.
 * It is a subclass of Command class.
 * "Quit" was entered. Check the rest of the command to see
 * whether we really quit the game. Return true, if this command
 * quits the game, false otherwise.
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 6th, April 2008
 */
public class Quit extends Command
{
	/**
     * Constructor for objects of class Quit
     */
	public Quit(String firstWord, String secondWord)
	{
		super(firstWord,secondWord);
	}
	
    /**
     * A player can quit the game.
     * @param command
     * @param player
     * @return true or false.
     */
	public boolean executeCommand(Command command, Player player, Parser parser)
	{
		if(command.hasSecondWord()) {
			System.out.println("Quit what?");
			return false;
		}
		else
			return true;  // signal that we want to quit
	}
}

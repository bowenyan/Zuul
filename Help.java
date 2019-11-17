/**
 * Class Help - a "help" action by the player.
 * It is a subclass of Command class.
 * Print out some help information.
 * Here we print some stupid, cryptic message and a list of the 
 * command words.
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * @author  Bowen Yan
 * @version 6th, April 2008
 */
public class Help extends Command
{
	/**
     * Constructor for objects of class Help
     */
	public Help(String firstWord, String secondWord)
	{
		super(firstWord,secondWord);
	}
    /**
     * A player can require a help.
     * @param command
     * @param player
     * @return
     */
	public boolean executeCommand(Command command, Player player, Parser parser)
	{
		if(!command.hasSecondWord()) {
            // if there is no second word, we don't know how to help the player...
            System.out.println("help what?");
            return false;
        }
		System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        return false;
	}
}

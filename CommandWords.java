import java.util.HashMap;
import java.util.Set;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 * @modified by Bowen Yan
 * @version 7th, April 2008
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    /*
	private static final String[] validCommands = {
        "go", "quit", "help","take","drop","lock","unlock","trade"
    };
    */
	private HashMap<String,Command> cList;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // initialise the Commands List
    	cList = new HashMap<String, Command>();
    	cList.put("go", new Go("go",null));
    	cList.put("quit", new Quit("quit",null));
    	cList.put("help", new Help("help",null));
    	cList.put("take", new Take("take",null));
    	cList.put("drop", new Drop("drop",null));
    	cList.put("lock", new Lock("lock",null));
    	cList.put("unlock", new Unlock("unlock",null));
    	cList.put("trade", new Trade("trade",null));
    }

    /**
     * Check whether a given String is a valid command word. 
     * Return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
         Set<String> keys = cList.keySet();
         for(String commands : keys)
         {
        	 if (commands.equals(aString)){
        		 return true;
        	 }
         }             
         return false;    // if we get here, the string was not found in the commands
    }

    /**
     * Print all valid commands to System.out.
     */
    public void showAll() 
    {
    	Set<String> keys = cList.keySet();
        for(String commands : keys)
        {
        	System.out.print(commands + "  ");
        }          
        System.out.println();
    }
    
    /**
     * Get a user's command.
     * @param firstWord
     * @param secondWord
     * @return a command.
     */
    public Command getCommand(String firstWord, String secondWord)
    {
    	Command cmd = cList.get(firstWord);
    	cmd.setCommandWord(firstWord, secondWord);
    	return cmd;
    }
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * The Command class should not be abstract class.
     */
    /*
    public boolean runCommand(Command command, Player player, Parser parser)
    {
    	String word1 = command.getCommandWord();
    	String word2 = command.getSecondWord();
    	Go go = new Go(word1,word2);
    	Quit quit = new Quit(word1,word2);
    	Help help = new Help(word1,word2);
    	Take take = new Take(word1,word2);
    	Drop drop = new Drop(word1,word2);
    	Lock lock = new Lock(word1,word2);
    	Unlock unlock = new Unlock(word1,word2);
    	Trade trade = new Trade(word1,word2);
    	if (word1.equals("go")){
    		go.executeCommand(command, player, parser);
    	}
    	if (word1.equals("quit")){
    		quit.executeCommand(command, player, parser);
    	}
    	if (word1.equals("help")){
    		help.executeCommand(command, player, parser);
    	}
    	if (word1.equals("take")){
    		take.executeCommand(command, player, parser);
    	}
    	if (word1.equals("drop")){
    		drop.executeCommand(command, player, parser);
    	}
    	if (word1.equals("lock")){
    		lock.executeCommand(command, player, parser);
    	}
    	if (word1.equals("unlock")){
    		unlock.executeCommand(command, player, parser);
    	}
    	if (word1.equals("trade")){
    		trade.executeCommand(command, player, parser);
    	}
    	return true;
    	
    }
    */
}

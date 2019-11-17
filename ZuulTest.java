/**
 * This class is for testing the Zuul assignment.
 * @author Bowen Yan
 *
 */
public class ZuulTest {
	public static void main(String[] args) {
		Game game;
		game = new Game();
		//testgame();
		game.play();
	}
	public static void testgame()
	{
		Game game;
		game = new Game();
		game.createRooms();
		game.processCommand(new Go("efre", "west"));
		game.processCommand(new Go("go", "east"));
		game.processCommand(new Go("go", "east"));
		game.processCommand(new Go("go", "west"));
		game.processCommand(new Go("go", "south"));
		game.processCommand(new Go("go", "east"));
		game.processCommand(new Go("go", "west"));
		game.processCommand(new Take("take", "milk"));
		game.processCommand(new Take("take", "bottle"));
		game.processCommand(new Take("take", "map"));
		game.processCommand(new Drop("drop", "map"));
		game.processCommand(new Drop("drop", "milk"));
		game.processCommand(new Trade("trade", "bottle"));
		game.processCommand(new Go("go", "north"));
		game.processCommand(new Unlock("unlock", "north"));
		game.processCommand(new Go("go", "north"));
		game.processCommand(new Lock("lock", "south"));
		game.processCommand(new Go("put", "north"));
		game.processCommand(new Quit("quit", null));
		game.processCommand(new Quit("quit", "game"));
	}

}

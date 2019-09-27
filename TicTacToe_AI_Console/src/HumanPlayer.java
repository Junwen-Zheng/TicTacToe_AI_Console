import java.util.Scanner;

/**
 * This class implements the Player interface and represents the human
 * player in the tic tac toe game.
 * 
 * @author
 *
 */
public class HumanPlayer implements Player {

	/** instance of the console to read move from player */
	static final Scanner console = new Scanner(System.in);
	
	@Override
	public String getName() {
		return "X";
	}

	@Override
	public Move move(Board board) {
		Move move = null;
		
		return move;
	}

	
}

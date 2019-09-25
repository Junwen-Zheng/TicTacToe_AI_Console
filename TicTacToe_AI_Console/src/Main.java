/**
 * This is the main driver class that plays the tic tac toe game between human and computer
 * player as a console based application.
 * 
 * @author
 *
 */
public class Main {

	public static void main(String[] args) {
		// Create the board
		Board board = new Board();
		
		// Create the two players
		Player humanPlayer = new HumanPlayer();
		Player compPlayer = new ComputerPlayer();
		
		// initialize the game
		Game game = new Game(board, humanPlayer, compPlayer);
		
		// play the game
		game.play();
	}

}

/**
 * 
 * This class implements the logic of the two player tic tac toe game where one is
 * HumanPlayer and other is ComputerPlayer.
 * 
 * @author
 *
 */
public class Game {

	/** the tic tac toe board */
	private Board board;
	
	/** the human player in the game */
	private Player humanPlayer;
	
	/** the computer player in the game */
	private Player compPlayer;
	
	/**
	 * Class constructor that initializes the game with board and players
	 */
	public Game(Board board, Player humanPlayer, Player compPlayer) {
		this.board = board;
		this.humanPlayer = humanPlayer;
		this.compPlayer = compPlayer;
	}
	
	/**
	 * Play the game with alternative turns for human and computer player
	 */
	public void play() {
		
	}
}

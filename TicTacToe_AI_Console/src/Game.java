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
	 * Play the game with alternative turns for human and computer player.
	 * @param humanFirst true if human takes the first move, otherwise false
	 */
	public void play(boolean humanFirst) {
		Player currPlayer = null;
		Player winner = null;
		boolean gameOver = false;
		
		if(humanFirst)
			currPlayer = humanPlayer;
		else
			currPlayer = compPlayer;
		
		
		// loop of the game for alternate turns until game is over
		while(!gameOver) {
			
			// display the current board
			board.print();
			
			// current player takes the turn
			Move move = currPlayer.move(board);
			
			// check if game is won by current player
			gameOver = hasWon(currPlayer);
			if(gameOver) {
				winner = currPlayer;
				break;
			}
			// check if game is a draw
			gameOver = isDraw();
			if(gameOver) break;
			
			
			// switch the current player for next turn
			currPlayer = switchPlayer(currPlayer);
		}
		
		
	}
	
	
	// -------- private helper methods -----------//
	
	/**
	 * Switch the player based on current player for next turn.
	 * 
	 * @param currPlayer the current Player
	 * @return the Player that will play the next turn
	 */
	private Player switchPlayer(Player currPlayer) {
		if(currPlayer == humanPlayer)
			return compPlayer;
		else
			return humanPlayer;
	}
	
	
	/**
	 * Check whether the game is over.
	 * 
	 * @return true if game is won by any player, otherwise false
	 */
	private boolean isGameOver() {
		return hasWon(humanPlayer) || hasWon(compPlayer);
	}
	
	/**
	 * Check if game is a draw indicating no more empty cell.
	 * 
	 * @return true if game is a draw, otherwise false
	 */
	private boolean isDraw() {
		for(int row = 0; row < board.getSize(); row++) {
			for(int col = 0; col < board.getSize(); col++) {
				if(board.get(row, col).isEmpty())
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Check whether the game is won by a given player.
	 * 
	 * @param player the given Player
	 * @return true if game is won by given player, otherwise false
	 */
	private boolean hasWon(Player player) {
		return board.hasThreeInRow(player);
	}
	
	
}

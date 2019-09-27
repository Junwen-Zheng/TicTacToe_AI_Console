import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the AI algorithm for ComputerPlayer's move
 * using minimax concepts.
 * 
 * @author
 *
 */
public class Minimax {

	public static int minimax(Board board, int depth, Player player) {
		return 0;
	}
	
	/**
	 * Get all possible moves from the current board.
	 * 
	 * @param board the current Board state
	 * @return a List<Move> containing all possible moves
	 */
	private List<Move> getPossibleMoves(Board board){
		List<Move> possibleMoves = new ArrayList<Move>();
		
		for(int row = 0; row < board.getSize(); row++) {
			for(int col = 0; col < board.getSize(); col++) {
				if(board.get(row, col).isEmpty()) {
					Move m = new Move(row,col);
					possibleMoves.add(m);
				}
			}
		}
		return possibleMoves;
	}
	
	/**
	 * Evaluate the current board for a given player.
	 * 
	 * @param board the current Board state
	 * @param player the given player
	 * @return the evaluated score of the player on given board
	 */
	private int evaluate(Board board, Player player) {
		int score = 0;
		
		return score;
	}
	
	
}

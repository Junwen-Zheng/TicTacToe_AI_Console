/**
 * This class defines the tic tac toe board configuration with markings
 * of each player on the board cells.
 * 
 * @author
 *
 */
public class Board {

	/** constant for the size of the board */
	static final int BOARD_SIZE = 3;
	
	/** 2d array to store player marking for all the board positions */
	private String[][] cells;
	
	/**
	 * Class constructor that creates and initializes the board
	 * with all empty cells.
	 */
	public Board() {
		cells = new String[BOARD_SIZE][BOARD_SIZE];
	}
	
	/**
	 * Get the player in a board cell position if any.
	 * 
	 * @param row the row position of the cell
	 * @param col the column position of the cell
	 * @return the String representing the player in given position if any, otherwise null
	 */
	public String get(int row, int col) {
		return cells[row][col];
	}
	
	/**
	 * Mark the a board position with a given player.
	 * 
	 * @param row the row position
	 * @param col the column position
	 * @param player the Player to mark the position with
	 */
	public void set(int row, int col, Player player) {
		
	}
	
	/**
	 * Check if a given position is a valid in the board
	 * @param row the row position
	 * @param col the column position
	 * @return true of position is valid, otherwise false
	 */
	public boolean isValidPosition(int row, int col) {
		if(row < 0 || row >= BOARD_SIZE) 
			return false;
		if(col < 0 || col >= BOARD_SIZE)
			return false;
		return true;
	}
}

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
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				cells[i][j] = "";
			}
		}
	}
	
	/**
	 * Get the size of the board.
	 * @return the size of the board
	 */
	public int getSize() {
		return BOARD_SIZE;
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
		if(isValidPosition(row, col)) {
			cells[row][col] = player.getName();
		}
	}
	
	/**
	 * Check if a given position is a valid in the board
	 * @param row the row position
	 * @param col the column position
	 * @return true if position is valid, otherwise false
	 */
	public boolean isValidPosition(int row, int col) {
		if(row < 0 || row >= BOARD_SIZE) 
			return false;
		if(col < 0 || col >= BOARD_SIZE)
			return false;
		return true;
	}
	
	/**
	 * Check if a given position is a valid move for a player
	 * @param player the given Player
	 * @param row the row position
	 * @param col the column position
	 * @return true if position is valid move for given player
	 */
	public boolean isValidMove(Player player, int row, int col) {
		if(!isValidPosition(row, col))
			return false;
		return cells[row][col].isEmpty();
	}
	
	
	/**
	 * Check to see if a given player has three positions in a row
	 * , column or diagonal.
	 * 
	 * @param player the given Player
	 * @return true if player has three consecutive positions marked in a row, otherwise false
	 */
	public boolean hasThreeInRow(Player player) {
		for(int row = 0; row < BOARD_SIZE; row++) {
			if((cells[row][0] == cells[row][1]) && (cells[row][1] == cells[row][2])) {
				if(cells[row][0] == player.getName())
					return true;
			}
		}
		for(int col = 0; col < BOARD_SIZE; col++) {
			if((cells[0][col] == cells[1][col]) && (cells[1][col] == cells[2][col])) {
				if(cells[0][col] == player.getName())
					return true;
			}
		}
		if((cells[0][0] == cells[1][1]) && (cells[2][1] == cells[2][2])) {
			if(cells[0][0] == player.getName())
				return true;
		}
		if((cells[2][0] == cells[1][1]) && (cells[1][1] == cells[0][2])) {
			if(cells[0][0] == player.getName())
				return true;
		}
		return false;
	}
	
	/**
	 * Display the board to console.
	 */
	public void print() {
		for(int i = 0; i < BOARD_SIZE; i++) {
			for(int j = 0; j < BOARD_SIZE; j++) {
				if(cells[i][j].isEmpty())
					System.out.print("_");
				else
					System.out.print(cells[i][j]);
			}
			System.out.println();
		}
	}
	
	
}

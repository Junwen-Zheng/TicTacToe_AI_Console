/**
 * Interface for various methods and attributes for a player along with
 * some constants for identifying players X and O
 *
 * @author
 *
 */
public interface Player {

    /** constant for the player X */
    static String PLAYER_X = "X";

    /** constant for the player O */
    static String PLAYER_O = "O";

    /**
     * Get the name of the player
     * @return the String representing the player
     */
    public String getName();

    /**
     * Make the next move of the player.
     *
     * @param board the Board instance on which the game is being played
     * @return the Move played by the player
     */
    public Move move(Board board);

}

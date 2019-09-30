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
    private static Player humanPlayer;

    /** the computer player in the game */
    private static Player compPlayer;

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

            // validate the move
            if(!board.isValidMove(currPlayer, move.getRow(), move.getColumn())) {
                System.out.println("Invalid Move!");
                continue;
            }
            // display the move to console
            System.out.println(currPlayer.toString()+" played move at " + move.toString());

            // apply the move to the board
            board.set(move.getRow(), move.getColumn(), currPlayer);

            // check if game is won by current player
            gameOver = hasWon(currPlayer);
            if(gameOver) {
                winner = currPlayer;
                break;
            }
            // check if game is a draw
            gameOver = board.isFull();
            if(gameOver) break;

            // switch the current player for next turn
            currPlayer = getOpponent(currPlayer);
        }

        // display the final board
        board.print();

        // --- game over (either win or tie) ---
        // Check if there is a winner
        if(winner != null) {
            System.out.println("Winner is " + winner);
        }
        else {
            System.out.println("Game is a Tie!");
        }

    }


    // -------- private helper methods -----------//

    /**
     * Switch the player based on current player for next turn.
     *
     * @param currPlayer the current Player
     * @return the Player that will play the next turn
     */
    public static Player getOpponent(Player currPlayer) {
        if(currPlayer == humanPlayer)
            return compPlayer;
        else
            return humanPlayer;
    }

    /**
     * Check whether the game is won by a given player.
     *
     * @param player the given Player
     * @return true if game is won by given player, otherwise false
     */
    private boolean hasWon(Player player) {
        return board.hasThree(player);
    }


}

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the Player interface and represents the computer
 * player in the tic tac toe game which uses MiniMax algorithm to make the
 * best possible move.
 *
 * @author
 *
 */
public class ComputerPlayer implements Player {

    // score factor for evaluating a board
    final int SCORE_FACTOR = 10;

    @Override
    public String getName() {
        return "O";
    }

    @Override
    public Move move(Board board) {
        Move bestMove = null;
        int bestScore = Integer.MIN_VALUE;
        Player opponent = Game.getOpponent(this);
        int score;

        // iterate over all possible moves for the given board
        for(Move m : getPossibleMoves(board)) {
            // make a clone of the current board
            Board copy = board.clone();
            // apply the move m in the board copy
            copy.set(m.getRow(), m.getColumn(), this);
            // if the moves ends the game evaluate the score
            if(copy.isFull() || copy.hasThree(this) || copy.hasThree(opponent)) {
                score = evaluate(copy);
            }
            else{ // else recursively call minimax
                score = minimax(copy, 5, false);
            }
            // update the best score
            if(score > bestScore) {
                bestScore = score;
                bestMove = m;
            }
        }
        return bestMove;
    }

    /**
     * The Minimax algorithm implementation with a given depth.
     *
     * @param board the current Board state
     * @param depth the current depth
     *
     * @return the best score of the player for given player and depth
     */
    public int minimax(Board board, int depth, boolean isMaxPlayer) {
        Player opponent = Game.getOpponent(this);
        // Check terminal condition (game is over i.e either tie or one player wins)
        if(depth == 0 || board.isFull() || board.hasThree(this) || board.hasThree(opponent))
            return evaluate(board);

        int bestScore;

        if(isMaxPlayer) {  // computer player, we need to maximise score
            bestScore = Integer.MIN_VALUE;
            for(Move m : getPossibleMoves(board)) {
                Board copy = board.clone();
                copy.set(m.getRow(), m.getColumn(), this);
                int score = minimax(copy, depth-1, false);
                if(score > bestScore)
                    bestScore = score;
            }
        }
        else {  // opponent player, we need to minimise score
            bestScore = Integer.MAX_VALUE;
            for(Move m : getPossibleMoves(board)) {
                Board copy = board.clone();
                copy.set(m.getRow(), m.getColumn(), opponent);
                int score = minimax(copy, depth-1, true);
                if(score < bestScore)
                    bestScore = score;
            }
        }

        return bestScore;
    }

    /**
     * Get all possible moves from the current board.
     *
     * @param board the current Board state
     * @return a List<Move> containing all possible moves
     */
    public List<Move> getPossibleMoves(Board board){
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
     * Heuristic function to evaluate the current board.
     *
     * @param board the current Board state
     * @return the evaluated score of the player on given board
     */
    private int evaluate(Board board) {
        // get opponent player of computer (which is human)
        Player opponent = Game.getOpponent(this);

        // if computer player wins return a +ve score factor
        if(board.hasThree(this))
            return SCORE_FACTOR;

        // if opponent player wins return a -ve score factor
        if(board.hasThree(opponent))
            return -SCORE_FACTOR;

        // neither wins, so return 0
        return 0;
    }


    @Override
    public String toString() {
        return "ComputerPlayer";
    }

}

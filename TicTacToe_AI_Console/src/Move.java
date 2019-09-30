/**
 * This class encapsulates details of a players move which is a position in the
 * board with a row and column values.
 *
 * @author
 *
 */
public class Move {

    /** row position of the move */
    private int row;

    /** column position of the move */
    private int column;

    /**
     * Class constructor that create a new Move object with given
     * parameters.
     *
     * @param row the row position
     * @param column the column position
     */
    public Move(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Get the row position of the move
     * @return the row position
     */
    public int getRow() {
        return row;
    }

    /**
     * Get the column position of the move.
     * @return the column position
     */
    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "("+row+", "+column+")";
    }

}

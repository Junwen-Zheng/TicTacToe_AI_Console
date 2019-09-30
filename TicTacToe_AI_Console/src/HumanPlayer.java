import java.util.Scanner;

/**
 * This class implements the Player interface and represents the human
 * player in the tic tac toe game.
 *
 * @author
 *
 */
public class HumanPlayer implements Player {

    /** instance of the console to read move from player */
    static final Scanner console = new Scanner(System.in);

    @Override
    public String getName() {
        return "X";
    }

    @Override
    public Move move(Board board) {
        // prompt user to enter the move
        System.out.print("Human Player's Turn\nEnter row, column separated by a space(e.g 2 2): ");

        // read the move from keyboard
        String[] input = console.nextLine().split(" ");

        // create Move object and return it
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        return new Move(row,col);
    }

    @Override
    public String toString() {
        return "HumanPlayer";
    }
}

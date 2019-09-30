/**
 * This is the main driver class that plays the tic tac toe game between human and computer
 * player as a console based application.
 *
 * The program takes an optional command line argument indicating whose takes the first turn. It is
 * one of the following.
 *
 * human: Human player takes the first turn
 * comp: Computer player takes the first turn
 *
 * If there is no command line argument then by default human player takes the first turn.
 * @author
 *
 */
public class Main {

    public static void main(String[] args) {
        boolean humanFirst = true;

        // Set who takes the first turn based on command line argument (if present)
        if(args.length > 0) {
            if(args[0].equalsIgnoreCase("comp")) {
                humanFirst = false;
            }
        }

        // Create the board
        Board board = new Board();

        // Create the two players
        Player humanPlayer = new HumanPlayer();
        Player compPlayer = new ComputerPlayer();

        // initialize the game
        Game game = new Game(board, humanPlayer, compPlayer);

        // play the game
        game.play(humanFirst);
    }

}
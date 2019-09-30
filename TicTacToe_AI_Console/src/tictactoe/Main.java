package tictactoe;
import tictactoe.ui.TicTacToeUI;

/**
 * This is the main driver class that plays the tic tac toe game between human
 * and computer player as a GUI based application.
 *
 * The program takes an optional command line argument indicating whose takes
 * the first turn. It is one of the following.
 *
 * human: Human player takes the first turn comp: Computer player takes the
 * first turn
 *
 * If there is no command line argument then by default human player takes the
 * first turn.
 *
 * @author
 *
 */
public class Main {

    public static void main(String[] args) {
        // instantiate the GUI window of the game and display it to used
        TicTacToeUI gameUI = new TicTacToeUI();
        gameUI.setSize(700,450);
        gameUI.setLocationRelativeTo(null);
        gameUI.setVisible(true);
    }

}

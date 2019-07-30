package src;

import src.Board;
import java.util.Scanner;

/**
 * The TicTacToe class contains a main method
 * which is used to run a game of Tic-Tac-Toe.
 * Each time the main method is run, a new instance
 * of a Board is created to track the state of the
 * game. A message is printed depending on if a player
 * won or the game tied.
 * 
 * @author Michael Glasser
 * @since 2019-7-29
 */
public class TicTacToe {

    public static void main(String[] args) {
        // Initalize the game
        Scanner kb = new Scanner(System.in);
        Board board = new Board();

        System.out.print("Welcome to Tic-Tac-Toe, are you ready to play? Here we go!\n\n");

        // Game loops until game over status is reached
        do {
            // Switch turns
            board.switchTurns();
            
            // Loop until a valid input is provided
            String space;
            boolean validInput = false;
            do {
                System.out.println(board.getBoard());
                System.out.print("\nPlayer " + board.getPlayerTurn() + ", what space do you want to play? : ");
                space = kb.nextLine();
                if (board.doesSpacesContain(space)) {
                    System.out.println();
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input. Please select an available space from 1-9\n");
                }
            } while (!validInput);
            
            // Mark the space provided
            board.markSpace(Integer.parseInt(space));
         } while ( !board.didGameTie() && !board.didPlayerWin() );

         // Print the appropriate game over message
         if (board.didPlayerWin()) {
            System.out.println("Game is over now. Player " + board.getPlayerTurn() + " is the winner!");
         } else if (board.didGameTie()) {
            System.out.println("Game is over now. There was a tie! Play again to determine the winner!");
         }

        kb.close();
    }
}
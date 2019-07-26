package src;

import src.Board;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Board board = new Board();
        String space;
        boolean validInput = false;

        System.out.print("Welcome to Tic-Tac-Toe, are you ready to play? Here we go!\n\n");

        do {
            board.switchTurns();
            
            do {
                System.out.println(board.board);
                System.out.print("\nPlayer " + board.playerTurn + ", what space do you want to play? : ");
                space = kb.nextLine();
                if (board.spaces.contains(space)) {
                    System.out.println();
                    validInput = true;
                } else {
                    System.out.println("\nInvalid input. Please select an available space from 1-9\n");
                    validInput = false;
                }
            } while (!validInput);
            
            board.markSpace(Integer.parseInt(space));
            board.didPlayerWin();
         } while ( !board.gameOver );

         System.out.println("Game is over now. Player " + board.playerTurn + " is the winner!");

        kb.close();
    }
}
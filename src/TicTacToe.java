package src;
import src.Board;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Board board = new Board();

        System.out.print("Welcome to Tic-Tac-Toe, are you ready to play? Here we go!\n\n");

        do {
            board.switchTurns();
            System.out.println(board.board);
            System.out.print("Player " + board.playerTurn + ", what space do you want to play? : ");
            int spaceNum = kb.nextInt();
            board.markSpace(spaceNum);
            board.didPlayerWin();
         } while ( !board.gameOver );

         System.out.println("Game is over now. Player " + board.playerTurn + " is the winner!");

        kb.close();
    }
}
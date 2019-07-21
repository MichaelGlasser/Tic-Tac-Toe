package src;
import src.Board;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Board board = new Board();

        System.out.print("Welcome to Tic-Tac-Toe, are you ready to play? Here we go!\n\n");

        System.out.println("Here is the board:");
        System.out.println(board.board);

        kb.close();
    }
}
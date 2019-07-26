package src;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
  public String board;
  public int playerTurn;
  public ArrayList<String> spaces;
  public Boolean gameOver;
  private int[][] winningLines = new int[][] { {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6} };

  public Board() {
    gameOver = false;
    playerTurn = 2;
    spaces = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9")) ;
    updateBoard();
  }

  public void switchTurns() {
    if (playerTurn == 1) {
      playerTurn = 2;
    } else {
      playerTurn = 1;
    }
  }

  public void markSpace(int space) {
    if (playerTurn == 1) {
      spaces.set(space - 1, "X");
    } else {
      spaces.set(space - 1, "O");
    }
    updateBoard();
  }

  private void updateBoard() {
    board = String.format(
      "%s|%s|%s\n" + "-----\n" + "%s|%s|%s\n" + "-----\n" + "%s|%s|%s", 
      spaces.get(0), spaces.get(1), spaces.get(2), spaces.get(3), spaces.get(4), spaces.get(5), spaces.get(6), spaces.get(7), spaces.get(8));
  }

  public void didPlayerWin() {
    String letterToCheck;
    if (playerTurn == 1) {
      letterToCheck = "X";
    } else {
      letterToCheck = "O";
    }

    for (int i = 0; i < winningLines.length; i++) {
      int count = 0;
      for (int j = 0; j < winningLines[i].length; j++) {
        if ( spaces.get(winningLines[i][j]).equals(letterToCheck) ) {
          count++;
        }
      }
      if ( count == 3 ) {
        gameOver = true;
        return;
      }
    }
  }
}
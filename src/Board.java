package src;

public class Board {
  public String board;
  public int playerTurn;
  public String[] spaces;
  public Boolean gameOver;
  private int[][] winningLines = new int[][] { {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6} };

  public Board() {
    gameOver = false;
    playerTurn = 2;
    spaces = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
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
      spaces[space - 1] = "X";
    } else {
      spaces[space - 1] = "O";
    }
    updateBoard();
  }

  private void updateBoard() {
    board = String.format(
      "%s|%s|%s\n" + "-----\n" + "%s|%s|%s\n" + "-----\n" + "%s|%s|%s", 
      spaces[0], spaces[1], spaces[2], spaces[3], spaces[4], spaces[5], spaces[6], spaces[7], spaces[8]);
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
        if ( spaces[ winningLines[i][j] ].equals(letterToCheck) ) {
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
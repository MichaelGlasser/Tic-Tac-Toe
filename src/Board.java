package src;

public class Board {
  public String board;
  public int playerTurn;
  public String[] spaces;

  public Board() {
    playerTurn = 1;
    spaces = new String[] { " ", " ", " ", " ", " ", " ", " ", " ", " " };
    board = String.format(
      "%s|%s|%s\n" + "-----\n" + "%s|%s|%s\n" + "-----\n" + "%s|%s|%s", 
      spaces[0], spaces[1], spaces[2], spaces[3], spaces[4], spaces[5], spaces[6], spaces[7], spaces[8]);
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
      spaces[space] = "X";
    } else {
      spaces[space] = "O";
    }
  }
}
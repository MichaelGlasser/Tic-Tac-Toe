package src;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Board class contains the state of a
 * game of TicTacToe and helper methods to
 * update the board and check for game over.
 * 
 * @author Michael Glasser
 * @since 2019-7-29
 */
public class Board {
  private int playerTurn;
  private ArrayList<String> spaces;
  private int[][] winningLines;
  private String board;

  /**
   * Constructor for the Board class.
   * Initalizes the board status for use
   * in a TicTacToe game.
   */
  public Board() {
    setPlayerTurn(2);
    spaces = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    winningLines = new int[][] { {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6} };
    setBoard();
  }

  /**
   * This method returns the playerTurn property
   * so that the game can read the value.
   * 
   * @return int Returns the playerTurn property
   */
  public int getPlayerTurn() {
    return playerTurn;
  }

  /**
   * This method sets the playerTurn property
   * 
   * @param turnNum The number that playerturn will be set to
   */
  private void setPlayerTurn(int turnNum) {
    playerTurn = turnNum;
  }

  /**
   * This method returns the value in the spaces
   * property at the defined index.
   * 
   * @param index The index to retrieve a value from
   * @return String The value in the spaces property at the index
   */
  public String getSpace(int index) {
    return spaces.get(index);
  }

  /**
   * This method sets a value at index in the
   * spaces property.
   * 
   * @param index The index in spaces that you want to update
   * @param value The value to update to
   */
  private void setSpace(int index, String value) {
    spaces.set(index - 1, value);
  }

  /**
   * This method returns an int[] listing a possible
   * winning line for Tic-Tac-Toe.
   * 
   * @param index The index of the int[] to return
   * @return int[] Returns an int[] listing a possible winning line
   */
  private int[] getWinningLine(int index) {
    return winningLines[index];
  }

  /**
   * This method returns the board property so
   * that the game can read the value.
   * 
   * @return String Returns the board property
   */
  public String getBoard() {
    return board;
  }

  /**
   * This method updates the board property to
   * reflect any new changes from the players turn.
   */
  private void setBoard() {
    board = String.format(
      "%s|%s|%s\n" + "-----\n" + "%s|%s|%s\n" + "-----\n" + "%s|%s|%s", 
      spaces.get(0), spaces.get(1), spaces.get(2), spaces.get(3), spaces.get(4), spaces.get(5), spaces.get(6), spaces.get(7), spaces.get(8));
  }

  /**
   * This method switches the playerTurn
   * between 1 and 2.
   */
  public void switchTurns() {
    if (getPlayerTurn() == 1) {
      setPlayerTurn(2);
    } else {
      setPlayerTurn(1);
    }
  }

  /**
   * This method checks the spaces property to
   * see if it contains a given value.
   * 
   * @param value The value to check for
   * @return boolean Returns true if value is found, false if not
   */
  public boolean doesSpacesContain(String value) {
    for (int i = 0; i < spaces.size(); i++) {
      if (getSpace(i).equals(value)) {
        return true;
      }
    }
    return false;
  }

  /**
   * This method assigns an X or O
   * in the space defined by the player
   * then updates the board.
   * 
   * @param space The number of the space provided by the player
   */
  public void markSpace(int space) {
    if (getPlayerTurn() == 1) {
      setSpace(space - 1, "X");
    } else {
      setSpace(space - 1, "O");
    }
    setBoard();
  }

  /**
   * This method checks if the game board has
   * resulted in a tie and sets the gameTied
   * property accordingly.
   * 
   * @return boolean Returns true or false depending on if the game is in a tie state.
   */
  public boolean didGameTie() {
    for (int i = 0; i < spaces.size(); i++) {
      if (!getSpace(i).equals("X") && !getSpace(i).equals("O")) {
        return false;
      }
    }
    return true;
  }

  /**
   * This method checks if the game board has
   * resulted in a win and sets the gameWon
   * property accordingly.
   * 
   * @return boolean Returns true or false depending on if the game is in a won state.
   */
  public boolean didPlayerWin() {
    // Determine which letter to check for based on playerTurn
    String letterToCheck;
    if (getPlayerTurn() == 1) {
      letterToCheck = "X";
    } else {
      letterToCheck = "O";
    }

    // Check all possible win conditions and return true if game is won or false if not
    for (int i = 0; i < winningLines.length; i++) {
      int count = 0;
      for (int j = 0; j < getWinningLine(i).length; j++) {
        if ( getSpace(getWinningLine(i)[j]).equals(letterToCheck) ) {
          count++;
        }
      }
      if ( count == 3 ) {
        return true;
      }
    }

    return false;
  }
}
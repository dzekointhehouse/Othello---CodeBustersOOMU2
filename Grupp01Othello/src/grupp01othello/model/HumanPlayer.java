/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;

import grupp01othello.view.GameBoard;

/**
 *
 * @author Markus
 */
public class HumanPlayer extends Player {
 
    private Move move;
    
    // Konstruktor: initialisera spelare med id?
    public HumanPlayer(int markerID, String playerName){
        super.setID(markerID);
        super.setName(playerName);
        move = new Move(-1,-1);
    }
    



    public void setMove(int row, int col) {
        // if( row && col == possible move)
      //  System.out.println("row: " + row + " col: " + col);
        move.setMove(row, col);
    }
      
  boolean madeAMove(){
      
      if (move.getRow() > -1 && move.getColumn() > -1)
          return true;
      return false;
  }

    @Override
    public Move getMove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
   public void getMoveTest(){
       
       move.setMove(row, col);
       System.out.println();
   }
}

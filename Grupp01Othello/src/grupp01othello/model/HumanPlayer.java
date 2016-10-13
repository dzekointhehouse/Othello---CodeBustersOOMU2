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
 
    // Konstruktor: initialisera spelare med id?
    public HumanPlayer(int markerID, String playerName){
        super.setID(markerID);
        super.setName(playerName);
    }
    
    /**
    * getMove returnerar draget som spelaren vill göra 
    * 
     * @param grid
     * @return 
     * int, inte void
    */
   
//   public void getMove(int row, int col, GameGrid grid) {
//     if(!grid.isPossibleMove(row, col))
//         System.out.println("false");
//          
//    }
//}
 public void getMove() {
        
         System.out.println("getMove: row: "+row+ "col: "+ col);
                   
    }
}

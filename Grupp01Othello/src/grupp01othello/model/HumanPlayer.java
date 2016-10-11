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
    public HumanPlayer(){}
    
    /**
    * getMove returnerar draget som spelaren vill göra 
    * 
    */
    @Override
   public int getMove(int row, int col, GameGrid grid) {
     if(!grid.isPossibleMove(row, col))
         System.out.println("false");
     return 0;
    }
}

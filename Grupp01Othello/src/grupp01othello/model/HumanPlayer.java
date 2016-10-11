/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;

import static grupp01othello.model.GameGrid.isPossibleMove;

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
   public int getMove(int row, int col) {
     if(!isPossibleMove(row,col))
         System.out.println("false");
     return 0;
    }
}

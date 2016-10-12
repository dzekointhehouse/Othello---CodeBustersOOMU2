/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;

import grupp01othello.model.GameGrid;
/**
 *
 * @author Markus
 */
 abstract public class Player {
    private String name;
    private int markerID;
    
    
    String getName(){
    return name;
    }
   
    void setName(String name){
      this.name = name;
    
    }
    int getID(){
    return markerID;
    }
    void setID(int markerID){
    this.markerID = markerID;
    }
    /**
    * getMove returnerar draget som spelaren vill göra 
    * 
     * @param row
     * @param col
     * @return 
    */
     abstract int getMove(int row,int col, GameGrid grid);
     
}

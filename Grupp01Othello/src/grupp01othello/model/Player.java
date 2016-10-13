/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;
import grupp01othello.controller.*;
import grupp01othello.model.GameGrid;
/**
 *
 * @author Markus
 */
 
public abstract class Player extends PlayerMoveHandler {
    protected String name;
    protected int markerID;
    PlayerMoveHandler handler = new PlayerMoveHandler();
    int row,col;
    
    public Player(){
    
    }
    void setName(String name){
    this.name = name;
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
//    setPlayer(String name, int markerID){
//    if(player.equals("Human")){
//    player = new HumanPlayer();
//    }
    
    //}
     public void setMove(){
    this.row = handler.getRow();
    this.col = handler.getCol();
    }
    public abstract void getMove();
     
}

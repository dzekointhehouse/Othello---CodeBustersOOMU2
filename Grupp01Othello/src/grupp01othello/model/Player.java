 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;
import grupp01othello.controller.*;
import grupp01othello.model.GameGrid;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
/**
 *
 * @author Markus
 */
 
public abstract class Player {
    
    private BooleanProperty hasMadeMove = new SimpleBooleanProperty(false);

    protected String name;
    public int markerID;
    int row,col;
    
    public Player(){
    
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setID(int markerID){
        this.markerID = markerID;
    }
    
    public BooleanProperty hasMadeMoveProperty(){
        return this.hasMadeMove;
    }
   

    public abstract void setMove(int row, int col);
     
    public abstract Move getMove();
    
       public abstract void getMoveTest();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;

/**
 *
 * @author optimusprime
 */
public class Move {
    
    private int row, column;
    
    public Move(int row, int column){
        this.row = row;
        this.column = column;
    }
    
    public void setMove(int row, int column){
        this.row = row;
        this.column = column;
    }
    
    public int getRow(){
        return this.row;
}

    public int getColumn(){
        return this.column;
}
}
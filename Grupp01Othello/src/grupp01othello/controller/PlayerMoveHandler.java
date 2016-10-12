/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author optimusprime
 */
public class PlayerMoveHandler{

    private int row, col;
    
    public void GetCoordinates(int row, int col){
        this.row = row;
        this.col = col;
            System.out.print("row: " + row + " col: " + col);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.controller;

import grupp01othello.model.GameGrid;
import grupp01othello.model.players.*;
import grupp01othello.view.GameBoard;
import grupp01othello.view.dialog.setUpGameDialog;

/**
 *
 * @author Markus, Elvir
 */
public class PlayerFactory {

    setUpGameDialog dialog = new setUpGameDialog();
    Player player1, player2;
    
    GameGrid grid;
    GameBoard board;

    PlayerFactory(GameGrid grid, GameBoard board) {

        this.grid = grid;
        this.board = board;
        
        player1 = new LocalComputerPlayer(1, "elvir", grid);
                player2 = new LocalComputerPlayer(2, "elvir", grid);
        //player2 = new HumanPlayer(2, grid, board);

        
//        typePlayer = dialog.infoBox();
//        name = dialog.infoBoxName();

    //    player1 = new HumanPlayer(2, name);
    }

    public Player getPlayerOne() {
        return player1;
    }

    public Player getPlayerTwo() {
        return player2;
    }

}

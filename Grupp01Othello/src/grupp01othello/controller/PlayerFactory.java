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

    Player player1, player2;
    String playerName,playerType,playerName2,playerType2;
    GameGrid grid;
    GameBoard board;

    PlayerFactory(GameGrid grid, GameBoard board) {
        
    setUpGameDialog dialog;
        dialog = new setUpGameDialog();
        this.grid = grid;
        this.board = board;
     
       playerType = dialog.startUpScene();
    // playerType = dialog.setCheckBox(); //döp metoden till setTypeOfPlayer?
   //  playerName = dialog.setComboBox();
//     
//     if(playerType.equals("Human"))
//       player1 = new HumanPlayer(1,grid,board);
//     
      player1 = new LocalComputerPlayer(1, "elvir", grid);
                player2 = new LocalComputerPlayer(2, "Markus", grid);

//        player1 = new HumanPlayer(1, grid, board);
 //     player2 = new HumanPlayer(2, grid, board);

        //göra såhär ist? mkt enklare
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

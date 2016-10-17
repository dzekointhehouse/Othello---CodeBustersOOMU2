/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.controller;

import grupp01othello.model.HumanPlayer;
import grupp01othello.model.Player;
import grupp01othello.view.setUpGameDialog;

/**
 *
 * @author Markus, Elvir
 */
public class PlayerFactory {

    setUpGameDialog dialog = new setUpGameDialog();
    Player player1, player2;

    PlayerFactory() {

        String typePlayer, name;

        /* hämtar spelartyp och namn */
     //   typePlayer = dialog.infoBox();
       // name = dialog.infoBoxName();

        player1 = new HumanPlayer(1, "elvir");
        player2 = new HumanPlayer(2, "markus");

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model.players;

import grupp01othello.model.Move;
import grupp01othello.model.OthelloGrid;
import java.util.ArrayList;
import grupp01othello.server.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Markus skapade filen, men Elvir implementerade :P:P
 */
public class RemoteComputerPlayer extends Player {

    private OthelloClient client;
    /* Konstruktor */
    public RemoteComputerPlayer(int markerID, String playerName, OthelloGrid grid) throws IOException {
        super(markerID, playerName, grid);
        client = new OthelloClient();
    }

    @Override
    public void setMove(int row, int col) {
        move.setRow(row);
        move.setColumn(col);
    }

    @Override
    public Move getMove() {
        try {

            ArrayList<Move> legalMoves = grid.getLegalMoves(markerID);

            resetMove();
            /* Kollar så att det finns lagliga drag innan vi skickar till servern. */
            if (legalMoves.size() != 0) {
                //System.out.print(legalMoves.size());
                    client.sendtoServer(legalMoves.size());
                    this.move = legalMoves.get(client.recieveFromServer());
            } else {
                /* Återställer draget ifall det inte kommer finnas lagliga drag. */
                resetMove();
            }
        } catch (IOException ex) {
            Logger.getLogger(RemoteComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print("row: " + move.getRow() + "col: " + move.getColumn());
        return move;
    }

    /**
     * resetMove, används för att återställa värdet på kordinaterna när det inte
     * finns ett möjligt drag.
     */
    public void resetMove() {
        move.setColumn(-1);
        move.setRow(-1);
    }
}

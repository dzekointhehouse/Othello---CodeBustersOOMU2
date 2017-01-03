/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model.players;

import grupp01othello.model.OthelloGrid;
import grupp01othello.model.Move;
import java.util.ArrayList;
import java.util.Random;
//exit

/**
 *
 * @author Markus
 */
public class LocalComputerPlayer extends Player {

    /* Konstruktor */
    public LocalComputerPlayer(int markerID, String playerName, OthelloGrid grid) {
        super(markerID, playerName, grid);

    }

    @Override
    public void setMove(int row, int col) {
        move.setRow(row);
        move.setColumn(col);
    }

    @Override
    public Move getMove() {
        try {
            Thread.sleep(1000);
            /* genererar ett slumpmässigt drag */
            generateMove();
        } finally {
            return move;
        }
    }

    /**
     * genererar de möjliga drag som spelaren kan göra.
     */

    public void generateMove() {

        ArrayList<Move> legalMoves = grid.getLegalMoves(markerID);

        if (legalMoves.isEmpty()) {
            resetMove();
        } else {
            Random randomMove = new Random();
            int index = randomMove.nextInt(legalMoves.size()); // slumpar genom möjliga drag.

            move.setRow(legalMoves.get(index).getRow());
            move.setColumn(legalMoves.get(index).getColumn()); // sätter in slumpade dragen som move.
        }
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

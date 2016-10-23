/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model.players;

import grupp01othello.model.GameGrid;
import grupp01othello.model.Move;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Markus
 */
public class LocalComputerPlayer extends Player {

    private Move move;
    GameGrid grid;

    public LocalComputerPlayer(int markerID, String playerName, GameGrid grid) {
        this.grid = grid;
        super.setID(markerID);
        super.setName(playerName);
        move = new Move(-1, -1);
    }

    public void setMove(int row, int col) {
        move.setRow(row);
        move.setColumn(col);
        ArrayList<Move> legalMoves = grid.GetAllLegalMoves(markerID);

        if (legalMoves.size() == 0) {
            this.hasMadeMoveProperty().set(true); // har gjort ett drag, om det inte finns några lagliga drag att göra.
        } else {
            Random randomMove = new Random();
            int index = randomMove.nextInt(legalMoves.size() - 1); // slumpar genom möjliga drag.

            this.hasMadeMoveProperty().set(true); // true = har gjort ett drag.
            
            move.setRow(legalMoves.get(index).getRow());
            move.setColumn(legalMoves.get(index).getRow()); // sätter in slumpade dragen som move.
        }

    }

    @Override
    public Move getMove() {
        try {     
            Thread.sleep(2000);
        } catch (Exception e) {
            
        } finally {
            this.hasMadeMoveProperty().set(false);
            return move;
        }
    }

    @Override
    public void getLegalMoves(ArrayList<Move> allmoves) {
        ArrayList<Move> legalMoves = allmoves;

        if (legalMoves.size() == 0) {
            this.hasMadeMoveProperty().set(true); // har gjort ett drag, om det inte finns några lagliga drag att göra.
        } else {
            Random randomMove = new Random();
            int index = randomMove.nextInt(legalMoves.size() - 1); // slumpar genom möjliga drag.

            move.setRow(legalMoves.get(index).getRow());
            move.setColumn(legalMoves.get(index).getColumn()); // sätter in slumpade dragen som move.
            this.hasMadeMoveProperty().set(true); // true = har gjort ett drag.

        }
    }
}

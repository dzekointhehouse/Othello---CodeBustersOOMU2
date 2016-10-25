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
//exit
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

    @Override
    public void setMove(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public Move getMove() {
        try {
            Thread.sleep(2000);
            generateMove();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.hasMadeMoveProperty().set(false);
            return move;
        }
    }


    public void generateMove() {

        ArrayList<Move> legalMoves = grid.getAllLegalMoves(markerID);

        if (legalMoves.isEmpty()) {
            this.hasMadeMoveProperty().set(true); // har gjort ett drag, om det inte finns några lagliga drag att göra.
            resetMove();
        } else {
            Random randomMove = new Random();
            int index = randomMove.nextInt(legalMoves.size() - 1); // slumpar genom möjliga drag.

            move.setRow(legalMoves.get(index).getRow());
            move.setColumn(legalMoves.get(index).getColumn()); // sätter in slumpade dragen som move.
            this.hasMadeMoveProperty().set(true); // true = har gjort ett drag.
        }
    }
    /**
     * resetMove, används för att återställa värdet på kordinaterna när det inte finns ett möjligt drag.
     */
    public void resetMove(){
        move.setColumn(-1);
        move.setRow(-1);
    }
}

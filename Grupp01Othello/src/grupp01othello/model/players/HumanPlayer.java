/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model.players;

import grupp01othello.model.GameGrid;
import grupp01othello.model.Move;
import grupp01othello.view.GameBoard;
import java.util.ArrayList;

/**
 *
 * @author Markus, Elvir
 */
public class HumanPlayer extends Player {

    private Move move;
    GameGrid grid;
    GameBoard board;

    public HumanPlayer(int markerID, GameGrid grid, GameBoard board) {
        this.grid = grid;
        this.board = board;
        super.setID(markerID);
        move = new Move(-1, -1);
    }

    /**
     * Denna metod används i Gameboard, för att få in ett nytt drag från
     * spelaren vid ett event (kanske ha ett interface mellan dem), draget som
     * gjorts jämförs med alla lagliga drag som hämtas från gamegrid.
     *
     * @param row
     * @param col
     */
    @Override
    public void setMove(int row, int col) {

        ArrayList<Move> legalMoves = grid.getAllLegalMoves(markerID);

        for (int i = 0; i < legalMoves.size(); i++) {
            if (row == legalMoves.get(i).getRow() && col == legalMoves.get(i).getColumn()) {
                move.setRow(row);
                move.setColumn(col);
                this.hasMadeMoveProperty().set(true);
            }
        }

    }

    /**
     * Denna metoden väntar på att den mänskliga spelaren ska få in ett giltigt
     * drag från setMove och då avbryts loopen och draget retuneras.
     *
     * @return Move
     */
    @Override
    public Move getMove() {

        while (!this.hasMadeMoveProperty().get()) { // väntar på drag ett drag.
            try {
                /* skickar denna instansen som handler i gameboard. */
                board.handleGameBoard(this);
            } catch (Exception e) {
                e.getStackTrace();
            }
            /* hoppa ur loopen om ett drag har gjorts (true) */
            if (this.hasMadeMoveProperty().get()) {
                break;
            }
        }
        /* ändrar till false igen inför nästa drag och
           retunerar aktuellt drag. */
        this.hasMadeMoveProperty().set(false);
        return move;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model.players;

import grupp01othello.model.OthelloGrid;
import grupp01othello.model.Move;
import grupp01othello.view.BoardTile;
import grupp01othello.view.GameBoard;
import java.util.ArrayList;

/**
 *
 * @author Markus, Elvir
 */
public class HumanPlayer extends Player {

    private Object lock = new Object();

    /* Konstruktor */
    public HumanPlayer(int markerID, String playerName, OthelloGrid grid, GameBoard board) {
        super(markerID, playerName, grid);
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

        ArrayList<Move> legalMoves = grid.getLegalMoves(markerID);
        /* vi tillsätter ett lås och notifierar getmove när vi har fått ett drag. */
        synchronized (lock) {
            for (int i = 0; i < legalMoves.size(); i++) {
                if (row == legalMoves.get(i).getRow() && col == legalMoves.get(i).getColumn()) {
                    move.setRow(row);
                    move.setColumn(col);

                    lock.notify();
                }
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

        /* Här låser vi och väntar på att det ska komma in ett drag. */
        synchronized (lock) {
            try {
                lock.wait();
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return move;
    }

}

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
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Markus
 */
public class HumanPlayer extends Player {

    private Move move;
    GameGrid grid;
    GameBoard board;

    public HumanPlayer(int markerID, GameGrid grid, GameBoard board) {
        this.grid = grid;
        super.setID(markerID);
        move = new Move(-1, -1);
        this.board = board;
                        board.handleGameBoard(this);

    }

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

    @Override
    public Move getMove() {
        while (!this.hasMadeMoveProperty().get()) {
            try {
                board.handleGameBoard(this);
                Thread.currentThread().sleep(50);

            } catch (Exception e) {
                e.getStackTrace();
            }
            if (this.hasMadeMoveProperty().get()) {
                break;
            }
        }
        this.hasMadeMoveProperty().set(false);
        return move;
    }

    public void getLegalMoves() {

    }

}

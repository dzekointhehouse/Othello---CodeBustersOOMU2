/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model;

import grupp01othello.view.GameBoard;
import java.util.EventListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author Markus
 */
public class HumanPlayer extends Player implements Runnable {

    private Move move;


    public HumanPlayer(int markerID, String playerName) {
        super.setID(markerID);
        super.setName(playerName);
        move = new Move(-1, -1);
    }

    public void setMove(int row, int col) {
        move.setMove(row, col);
        this.hasMadeMoveProperty().set(true);
    }

    boolean madeAMove() {

        if (move.getRow() > -1 && move.getColumn() > -1) {
            return true;
        }
        return false;
    }

    @Override
    public Move getMove() {
        this.hasMadeMoveProperty().set(false);
        return move;
    }

    @Override
    public void run() {

    }
}
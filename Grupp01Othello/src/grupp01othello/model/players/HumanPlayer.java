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
import java.util.EventListener;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author Markus
 */
public class HumanPlayer extends Player {

    private Move move;
    GameGrid grid;

    public HumanPlayer(int markerID, String playerName, GameGrid grid) {
        this.grid = grid;
        super.setID(markerID);
        super.setName(playerName);
        move = new Move(-1, -1);
    }

    public void setMove(int row, int col) {
        move.setMove(row, col);
        ArrayList<Move> moves = grid.GetAllLegalMoves(markerID);
        for (int i = 0; i < moves.size(); i++)
            if (move.getRow() == moves.get(i).getRow() && move.getColumn() == moves.get(i).getColumn())
        this.hasMadeMoveProperty().set(true);
    }


    @Override
    public Move getMove() {
        this.hasMadeMoveProperty().set(false);
        return move;
    }

}
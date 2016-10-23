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
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Markus
 */
public class HumanPlayer extends Player implements EventHandler<MouseEvent> {

    private Move move;
    GameGrid grid;
    GameBoard board;

    public HumanPlayer(int markerID, GameGrid grid, GameBoard board) {
        this.grid = grid;
        super.setID(markerID);
        move = new Move(-1, -1);
        this.board = board;

    }

    public void setMove(int row, int col) {

        ArrayList<Move> moves = grid.GetAllLegalMoves(markerID);
        
        for (int i = 0; i < moves.size(); i++) {
            if (row == moves.get(i).getRow() && col == moves.get(i).getColumn()) {
                move.setRow(row);
                move.setColumn(col);
                this.hasMadeMoveProperty().set(true);
            }
        }
    }


    @Override
    public Move getMove() {
        this.hasMadeMoveProperty().set(false);
        return move;
    }

    @Override
    public void handle(MouseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void getLegalMoves(ArrayList<Move> allmoves){
        
        
    }

}
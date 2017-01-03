/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.model.players;

import grupp01othello.model.Move;
import grupp01othello.model.OthelloGrid;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
//exit

/**
 *
 * @author Markus
 */
public abstract class Player {

    public int markerID;
    /* De attribut subklasserna behöver komma åt */
    protected String name;
    protected OthelloGrid grid;
    protected Move move;

    /* Konstruktor */
    public Player(int markerID, String playerName, OthelloGrid grid) {
        this.name = playerName;
        this.markerID = markerID;
        this.grid = grid;
        move = new Move(-1, -1); // representerar inget- eller ett ogiltigt drag.
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Setter metod för att sätta markörID.
     *
     * @param markerID
     */
    public void setID(int markerID) {
        this.markerID = markerID;
    }


    /* Abstrakta metoder */
    public abstract void setMove(int row, int col);

    public abstract Move getMove();

}

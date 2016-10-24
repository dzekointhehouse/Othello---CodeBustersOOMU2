/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view;

import grupp01othello.model.players.Player;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author optimusprime (Elvir Dzeko).
 */
public class BoardCell extends Pane {

    private BooleanProperty hasClicked = new SimpleBooleanProperty(false);
    private int row, col;

    public BoardCell(int row, int col) {

        /* row och col skickas vid event. */
        this.row = row;
        this.col = col;

        this.setPrefSize(2000, 2000);

    }

    /**
     * Målar upp spelbrickan på brädan efter spelarens markörID.
     *
     * @param markerID
     * @return Ellipse
     */
    public Ellipse setBrick(int markerID) {

        Ellipse brick = new Ellipse(this.getWidth() / 2,
                this.getHeight() / 2, this.getWidth() / 2 - 10,
                this.getHeight() / 2 - 10);

        brick.radiusXProperty().bind(
                this.widthProperty().divide(2).subtract(10));
        brick.radiusYProperty().bind(
                this.heightProperty().divide(2).subtract(10));
        brick.centerXProperty().bind(
                this.widthProperty().divide(2));
        brick.centerYProperty().bind(
                this.heightProperty().divide(2));

            /* 1 = Svart Bricka */
        if (markerID == 1) {
            brick.setFill(Color.BLACK);
            brick.setStroke(Color.WHITE);
            /* 2 = vit Bricka */
        } else if (markerID == 2) {
            brick.setFill(Color.WHITE);
            brick.setStroke(Color.BLACK);
            /* Genomsynlig */
        } else {
            brick.setFill(Color.TRANSPARENT);
            brick.setStroke(Color.TRANSPARENT);
        }
        return brick;
    }

    /**
     * Metod som kan anropas för att skicka in en spelare för att hantera ett
     * mouse event som kan ske när cellen blir clickad. Då kan spelaren få
     * koordinaterna genom setMove.
     *
     * @param player
     */
    public void brickClicked(Player player) {

        /* Spelaren som skickas in hanterar mouseevents med anrop till setMoves */
        this.setOnMouseClicked(event -> {
            player.setMove(row, col); // skicka event?

        });
    }
}

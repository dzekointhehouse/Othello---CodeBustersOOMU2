/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view;

import grupp01othello.model.Player;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author optimusprime
 */

public class BoardCell extends Pane {

    private int row, col;

    public BoardCell(int row, int col) {

        /* information som används senare i gamegrid, de skickas med i eventhandling. */
        this.row = row;
        this.col = col;

        this.setPrefSize(2000, 2000);

    }

    public Ellipse setBrick(int token) {

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
        if (token == 1) {
            brick.setFill(Color.BLACK);
            brick.setStroke(Color.WHITE);
        /* 2 = vit Bricka */
        } else if (token == 2) {
            brick.setFill(Color.WHITE);
            brick.setStroke(Color.BLACK);
        /* Genomsynlig */
        } else {
            brick.setFill(Color.TRANSPARENT);
            brick.setStroke(Color.TRANSPARENT);
        }
        return brick;
    }

    public void brickClicked(Player player) {

        /* Spelaren som skickas in hanterar draget med setMoves */
        this.setOnMouseClicked(event -> {          
            player.setMove(this.row, this.col);          
        });
    }
}

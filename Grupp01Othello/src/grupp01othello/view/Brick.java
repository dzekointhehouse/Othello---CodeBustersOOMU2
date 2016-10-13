/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view;

import grupp01othello.controller.PlayerMoveHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
/**
 *
 * @author optimusprime
 */
    
public class Brick extends Pane {

    // Token used for this cell
    private int token = 0; // representerar att token (rutan är tom)
    private int row, col;
    
    public Brick(int row, int col) {

        // information som används senare i gamegrid, de skickas med i eventhandling.
        this.row = row;
        this.col = col; 
        
        this.setPrefSize(2000, 2000);
        brickClicked();


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

        if (token == 1) {
            brick.setFill(Color.BLACK);
            brick.setStroke(Color.WHITE);
        } if (token == 2) {
            brick.setFill(Color.WHITE);
            brick.setStroke(Color.BLACK);
        } else{
            brick.setFill(Color.TRANSPARENT);
            brick.setStroke(Color.TRANSPARENT);
        }

        return brick;       
        
    }
    
    public void brickClicked(){
        
        this.setOnMouseClicked(event -> {
            PlayerMoveHandler brickHandler = new PlayerMoveHandler();
            brickHandler.GetCoordinates(row, col);
            
        });
        
        
    }
}



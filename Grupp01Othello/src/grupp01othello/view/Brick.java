/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupp01othello.view;

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

        public Brick(int row, int col) {

            if ((row + col) % 2 == 0) {
                setStyle("-fx-background-color: #2b6235");
            } else {
                setStyle("-fx-background-color: #023a00");
            }
            //  setStyle("-fx-border-color: #000000");
            this.setPrefSize(2000, 2000);

            this.setOnMouseClicked(event -> handleMouseClick());

        }

        public Ellipse setBrick(int type) {

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

        

            if (type == 1) {
                brick.setFill(Color.BLACK);
                brick.setStroke(Color.WHITE);
            } else {
                brick.setFill(Color.WHITE);
                brick.setStroke(Color.BLACK);
            }
            
            
            return brick;
        }


        /**
         * detta hanteras inte än på rätt sätt. men används nu för att testa
         * programmet.
         */
        public void handleMouseClick() {

            this.getChildren().add(setBrick(2));
        }

    }



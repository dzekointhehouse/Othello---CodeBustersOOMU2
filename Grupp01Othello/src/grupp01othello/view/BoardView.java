package grupp01othello.view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import grupp01othello.view.setUpGameDialog;
/**
 * Created by optimusprime on 2016-09-27.
 */
public class BoardView {

    private Stage stage = new Stage();
    GridPane board = new GridPane();
    
    public BoardView() {

    }

    /**
     * Denna method lägger in celler i gridpane som skall då
     * användas som rutor i spelet.
     * @return GridPane
     */
    public GridPane getBoard() {
        
        Cell[][] cell = new Cell[8][8];

        //lägger in celler
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.add(cell[i][j] = new Cell(i, j), j, i);
            }
        }

        return board;
    }

    public class Cell extends Pane {

        // Token used for this cell
        private int token = 0; // representerar att token (rutan är tom)

        public Cell(int row, int col) {

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
            
                    brick.centerXProperty().bind(
          this.widthProperty().divide(2));
        brick.centerYProperty().bind(
            this.heightProperty().divide(2));
        brick.radiusXProperty().bind(
            this.widthProperty().divide(2).subtract(10));        
        brick.radiusYProperty().bind(
            this.heightProperty().divide(2).subtract(10));   

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


    
    


}

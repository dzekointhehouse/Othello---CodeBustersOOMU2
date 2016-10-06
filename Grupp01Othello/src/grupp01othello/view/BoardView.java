package grupp01othello.view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class BoardView {

    private Stage stage = new Stage();
    GridPane board = new GridPane();
    public BoardView(){

    }

    public GridPane getBoard() {
        Cell[][] cell =  new Cell[8][8];

        //lägger in celler
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                board.add(cell[i][j] = new Cell(i, j), j, i);

    return board;
    }

    public class Cell extends Pane {
        // Token used for this cell
        private char token = ' ';

        public Cell(int row, int col) {

            if ((row + col) % 2 == 0)
                setStyle("-fx-background-color: #2b6235");
             else
                setStyle("-fx-background-color: #023a00");

          //  setStyle("-fx-border-color: #000000");
            this.setPrefSize(2000, 2000);

        }
    }



}

package grupp01othello.view;

import static grupp01othello.controller.GameManager.handleMouseClick;
import java.util.Observer;
import java.util.Observable;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameBoard implements Observer {

    private Stage stage;
    private GridPane board;

    public GameBoard() {
        stage = new Stage();
        board = new GridPane();
        createBoard();
    }

    /**
     * createBoard initialiserar brädan och skapar rutor som man kan lägga sina
     * brickor i, dessutom så sätts de fyra initiala bryckorna in på rätt plats.
     *
     * @return GridPane
     */
    private void createBoard() {

        Brick[][] brick = new Brick[8][8];


        //lägger in celler
        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {
                board.add(brick[row][col] = new Brick(row, col), col, row);

                       
                if ((row + col) % 2 == 0) {
                    brick[row][col].setStyle("-fx-background-color: #2b6235");
                } else {
                    brick[row][col].setStyle("-fx-background-color: #023a00");
                }

            }
        }

        brick[3][4].getChildren().add(brick[3][4].setBrick(1));
        brick[3][3].getChildren().add(brick[3][3].setBrick(2));
        brick[4][3].getChildren().add(brick[4][3].setBrick(1));
        brick[4][4].getChildren().add(brick[4][4].setBrick(2));
        board.setGridLinesVisible(true);

    }
                  

    /**
     * Hämtar den färdiga brädan så att man kan sätta in den i en annan pane,
     * t.ex. BorderPane.
     *
     * @return GridPane
     */
    public GridPane getBoard() {
        return this.board;
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}

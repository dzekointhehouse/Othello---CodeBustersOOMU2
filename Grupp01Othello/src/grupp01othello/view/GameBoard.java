package grupp01othello.view;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameBoard {

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


        //lägger in celler
        for (int row = 0; row < 8; row++) {
            
            for (int col = 0; col < 8; col++) {
                
                Brick brick = new Brick(row, col);
                board.add(brick, col, row);
                       
                if ((row + col) % 2 == 0) {
                    brick.setStyle("-fx-background-color: #2b6235");
                } else {
                    brick.setStyle("-fx-background-color: #023a00");
                }

            }
        }

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

    
    
    
}

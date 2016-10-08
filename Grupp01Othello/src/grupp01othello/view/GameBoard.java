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
     * createBoard initialiserar brädan och skapar rutor som man kan lägga sina brickor i,
     * dessutom så sätts de fyra initiala bryckorna in på rätt plats.
     * @return GridPane
     */
    private GridPane createBoard() {
        
        Brick[][] brick = new Brick[8][8];
        
        //lägger in celler
        for (int i = 0; i < 8; i++) {
            
            for (int j = 0; j < 8; j++) {
                board.add(brick[i][j] = new Brick(i, j), j, i);

            }
        }
        
        brick[3][4].getChildren().add(brick[3][4].setBrick(1));
        brick[3][3].getChildren().add(brick[3][3].setBrick(2));
        brick[4][3].getChildren().add(brick[4][3].setBrick(1));
        brick[4][4].getChildren().add(brick[4][4].setBrick(2));


        return board;
    }
    
    /**
     * Hämtar den färdiga brädan så att man kan sätta in den i en annan pane, t.ex. BorderPane.
     * @return GridPane
     */
    public GridPane getBoard(){
        return this.board;
    }
}

package grupp01othello.view;

import grupp01othello.model.Subject;
import java.util.Observer;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameBoard implements GridObserver {

    private Stage stage;
    private GridPane board;
    Brick[][] brick = new Brick[8][8];
    
    private Subject grid; // where the observed subject instance is kept.

    public GameBoard(Subject gamegrid) {
        stage = new Stage();
        board = new GridPane();
        createBoard();
        
        this.grid = gamegrid;
        grid.register(this); // registrerar denna klassen som en observer till gamegrid.
        
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
                board.add(brick[row][col] = new Brick(row, col), col, row);
                       
                if ((row + col) % 2 == 0) {
                    brick[row][col].setStyle("-fx-background-color: #2b6235");
                } else {
                    brick[row][col].setStyle("-fx-background-color: #023a00");
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

    @Override
    public void update(int[][] gameGrid) {

                for (int row = 0; row < 8; row++) {
                    System.out.println();
            for (int col = 0; col < 8; col++) {
               System.out.print(" " + gameGrid[row][col] + " ");
            }

        }


    }



    
    
    
}

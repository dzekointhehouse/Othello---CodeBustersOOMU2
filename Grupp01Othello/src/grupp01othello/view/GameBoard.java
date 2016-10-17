package grupp01othello.view;

import grupp01othello.model.Player;
import grupp01othello.model.Subject;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by optimusprime on 2016-09-27.
 */
public class GameBoard implements GridObserver {

    private Stage stage;
    private GridPane board;
    grupp01othello.view.BoardCell[][] brick;

    private Subject grid; // where the observed subject instance is kept.

    public GameBoard(Subject gamegrid) {

        stage = new Stage();
        board = new GridPane();
        brick = new grupp01othello.view.BoardCell[8][8];


        /* lägger till GameGrid instansen och registrerar sig på den som observer. */
        this.grid = gamegrid;
        grid.register(this);

        InitializeGameBoard();

    }

    /**
     * createBoard initialiserar brädan och skapar rutor som man kan lägga sina
     * brickor i, dessutom så sätts de fyra initiala bryckorna in på rätt plats.
     *
     * @return GridPane
     */
    public void InitializeGameBoard() {

        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {
                board.add(brick[row][col] = new grupp01othello.view.BoardCell(row, col), col, row); //lägger in celler

                if ((row + col) % 2 == 0) {
                    brick[row][col].setStyle("-fx-background-color: rgba(162, 150, 7, 0.81)");
                } else {
                    brick[row][col].setStyle("-fx-background-color: rgba(30, 48, 58, 0.8)");
                }

            }
        }

        board.setGridLinesVisible(false);

    }

    /**
     * retunerar brädan från denna instansen.
     * @return GridPane
     */
    public GridPane getBoard() {
        return this.board;
    }

    @Override
    public void update(int[][] gameGrid) {

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                brick[row][col].getChildren().add(brick[row][col].setBrick(gameGrid[row][col]));
            }
        }

    }

    public void handleGameBoard(Player player) {

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                brick[row][col].brickClicked(player);
            }
        }

    }

}

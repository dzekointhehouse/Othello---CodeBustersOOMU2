package grupp01othello.view;

import grupp01othello.model.Move;
import grupp01othello.model.players.Player;
import grupp01othello.model.Subject;
import java.util.ArrayList;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by optimusprime (Elvir) on 2016-09-27.
 */
public class GameBoard implements GridObserver {

    private Stage stage;
    private GridPane board;
    private final int SIZE;
    BoardTile[][] tile;

    private Subject gamegrid;

    /* konstruktorn: tar in ett objekt att observera, och storleken på brädan */
    public GameBoard(Subject gamegrid, int size) {

        SIZE = size;
        stage = new Stage();
        board = new GridPane();
        tile = new BoardTile[8][8];

        /* lägger till GameGrid instansen och registrerar sig på den som observer. */
        this.gamegrid = gamegrid;
        gamegrid.register(this);

        InitializeGameBoard();

    }

    /**
     * Initialiserar brädan, genom att lägga in en BoardTile i varje ruta, och skickar
     * med row och col. Vilket gör det lättare att referera till dem senare. Här får också
     * brädan sin rutiga charm.
     */
    private void InitializeGameBoard() {

        for (int row = 0; row < SIZE; row++) {

            for (int col = 0; col < SIZE; col++) {
                board.add(tile[row][col] = new BoardTile(row, col), col, row); //lägger in celler

                if ((row + col) % 2 == 0) {
                    tile[row][col].setStyle("-fx-background-color: rgba(162, 150, 7, 0.81)");
                } else {
                    tile[row][col].setStyle("-fx-background-color: rgba(30, 48, 58, 0.8)");
                }
            }
        }

        //board.setGridLinesVisible(false);
    }

    /**
     * retunerar brädan från denna instansen.
     *
     * @return GridPane
     */
    public GridPane getBoard() {
        return this.board;
    }

    /**
     * updateGrid uppdaterar GUIn när den underliggande observerade objektet
     * uppdateras. (då anropar den denna metod). Griden skickas med vid
     * uppdatering.
     *
     * @param grid
     */
    @Override
    public void updateGrid(int[][] grid) {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if(!tile[row][col].getChildren().isEmpty())
                    tile[row][col].getChildren().clear();
                tile[row][col].getChildren().add(tile[row][col].addPiece(grid[row][col]));
            }
        }
    }

    /**
     * player skickas som parameter för att hantera event, spelaren skickas till
     * varje tile, och på så sätt vet vi vilken tile som utlöste eventet.
     *
     * @param player
     */
    public void handleGameBoard(Player player) {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                tile[row][col].tileClicked(player);
            }
        }
    }

}
